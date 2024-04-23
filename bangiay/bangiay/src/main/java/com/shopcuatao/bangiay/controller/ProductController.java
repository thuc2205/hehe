package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.Service.ProductServiceImpl;
import com.shopcuatao.bangiay.dtos.ProductDTO;
import com.shopcuatao.bangiay.model.Products;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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
    @GetMapping("/list")
    public CompletableFuture<String> getAll(Model model
                                                       ){
        CompletableFuture<List<Products>> listCompletableFuture = productService.getAll();
        return listCompletableFuture.thenApply(list -> {
            model.addAttribute("products", list);
            return "/templates/index.html";
        });
    }
    @PutMapping({"/{id}"})
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody ProductDTO productDTO){
        Products products = productService.update(id,productDTO);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        productService.delete(id);
        return ResponseEntity.ok("Xóa Thành Công");
    }
}
