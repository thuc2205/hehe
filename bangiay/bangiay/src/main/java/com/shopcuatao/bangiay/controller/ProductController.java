package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.dtos.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/product")
public class ProductController {
    @PostMapping("")
    public ResponseEntity<?> createCategory(@RequestBody ProductDTO productDTO){
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
