package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.dtos.CategoriesDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/categories")
public class CategoryController {
    @PostMapping("")
    public ResponseEntity<?> createCategory(@RequestBody CategoriesDto categoriesDto){
        return ResponseEntity.ok(categoriesDto);
    }
    @GetMapping("")
    public ResponseEntity<?> getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
            ){
        return ResponseEntity.ok("THanh Con");
    }

    @PutMapping("/{id}")
        public ResponseEntity<?> updateCategory(@PathVariable int id,@RequestBody CategoriesDto categoriesDto){
        return ResponseEntity.ok(categoriesDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable int id){
        return ResponseEntity.ok("Xóa Thành CÔng");
    }




































































































}
