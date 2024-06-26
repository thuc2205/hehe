package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.Service.ProductDetaiServiceimpl;
import com.shopcuatao.bangiay.dtos.ProductDetailDTO;
import com.shopcuatao.bangiay.dtos.ProductImageDTO;
import com.shopcuatao.bangiay.model.ProductDetails;
import com.shopcuatao.bangiay.model.ProductImages;
import com.shopcuatao.bangiay.responese.ProductListRespones;
import com.shopcuatao.bangiay.responese.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
    @RequestMapping("${api.prefix}/productDetail")
@RequiredArgsConstructor
public class ProductDetailController {

    private final ProductDetaiServiceimpl productDetaiServiceimpl;

    @GetMapping("")
    public ResponseEntity<ProductListRespones>getAll(
            @RequestParam(defaultValue = "0",name = "category_id")int categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "9") int limit
    ){
        PageRequest pageRequest;
        if(categoryId==0){
            pageRequest = PageRequest.of(page,limit);
        }else{
            pageRequest= PageRequest.of(page,limit, Sort.by("id").ascending());
        }
        Page<ProductResponse> productPage = productDetaiServiceimpl.getAllProduct(pageRequest);
        int totalPage= productPage.getTotalPages();
        List<ProductResponse> list = productPage.getContent();
        return ResponseEntity.ok(ProductListRespones.builder()
                        .productResponses(list)
                        .totalPage(totalPage)
                .build());
    }


    @PostMapping("")
    public ResponseEntity<?> createProductDetail(@RequestBody ProductDetailDTO productDetailDTO, BindingResult result) throws Exception {
        if(result.hasErrors()){
            List<String> errCreateProduct = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
        }
        productDetaiServiceimpl.create(productDetailDTO);
        return ResponseEntity.ok(productDetailDTO);
    }
    @PostMapping(value = "/uploads/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadFile(@ModelAttribute("files")List<MultipartFile> files,
    @PathVariable("id") int productDetailId) throws IllegalAccessException, IOException {

        try{
            ProductDetails existingProductDetails = productDetaiServiceimpl.getProductsById(productDetailId);
            if(files.size() > 5){
                return ResponseEntity.badRequest().body("lỗi file");
            }

            List<ProductImages> productImagesList = new ArrayList<>();
            for (MultipartFile file : files){
                if(file!=null && file.getSize() > 0){
                    if(file.getSize() > 10*1024*1024){
                        throw new IllegalAccessException("file qua 10mb");
                    }
                    String fileName = kiemTraFile(file);
                    ProductImages productImages = productDetaiServiceimpl.createProductImage(existingProductDetails.getId(),
                            ProductImageDTO.builder()
                                    .imageUrl(fileName)
                                    .build()
                    );
                    productImagesList.add(productImages);

                }
            }
            return ResponseEntity.ok(productImagesList);
        }catch (Exception e){
            ResponseEntity.badRequest().body(e.getMessage());
        }


        return ResponseEntity.badRequest().body("lỗi");
    }
    private String kiemTraFile(MultipartFile file) throws IOException {
        if (file.getOriginalFilename() == null) {
            throw new IOException("Không phải ảnh");
        }

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));

        String uniqueFileName = java.util.UUID.randomUUID().toString() + "_" + fileName;

        Path fileUpload = Paths.get("upload");
        if (!Files.exists(fileUpload)) {
            Files.createDirectory(fileUpload);
        }
        Path destination = Paths.get(fileUpload.toString(), uniqueFileName);

        Files.copy(file.getInputStream(), destination, StandardCopyOption.REPLACE_EXISTING);

        return uniqueFileName;
    }

}
