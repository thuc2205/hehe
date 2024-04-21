package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.Service.ProductDetaiServiceimpl;
import com.shopcuatao.bangiay.dtos.ProductDTO;
import com.shopcuatao.bangiay.dtos.ProductDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
    @RequestMapping("${api.prefix}/productDetail")
@RequiredArgsConstructor
public class ProductDetailController {

    private final ProductDetaiServiceimpl productDetaiServiceimpl;
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
}
