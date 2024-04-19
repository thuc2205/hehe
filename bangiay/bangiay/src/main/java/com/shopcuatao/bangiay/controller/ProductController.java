package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.Service.ProductServiceImpl;
import com.shopcuatao.bangiay.dtos.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;
    @PostMapping("")
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO, BindingResult result){
        if(result.hasErrors()){
            List<String> errCreateProduct = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
        }
        productService.create(productDTO);
        return ResponseEntity.ok(productDTO);
    }
    @GetMapping("")
    public ResponseEntity<?> getAll(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok("lay ds thanh cong");
    }
    @PutMapping({"/{id}"})
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody ProductDTO productDTO){
        return ResponseEntity.ok("update Thành Công");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return ResponseEntity.ok("Xóa Thành Công");
    }
}
