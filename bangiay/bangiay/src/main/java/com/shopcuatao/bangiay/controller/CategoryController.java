package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.Service.CategoryServiceImpl;
import com.shopcuatao.bangiay.dtos.CategoriesDto;
import com.shopcuatao.bangiay.model.Categories;
import com.shopcuatao.bangiay.repositories.CategoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("${api.prefix}/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    @PostMapping("")
    public ResponseEntity<?> createCategory(@RequestBody CategoriesDto categoriesDto, BindingResult result){
        if(result.hasErrors()){
            List<String> err = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
        }
        categoryService.create(categoriesDto);
        return ResponseEntity.ok(categoriesDto);
    }
    @GetMapping("")
    public CompletableFuture<ResponseEntity<?>> getAllCategories(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
            ){
       CompletableFuture<List<Categories>> listCompletableFuture = categoryService.getAll();
        return  listCompletableFuture.thenApply(list -> ResponseEntity.ok(listCompletableFuture));
    }

    @PutMapping("/{id}")
        public ResponseEntity<?> updateCategory(@PathVariable int id,@RequestBody CategoriesDto categoriesDto){
        Categories categories = categoryService.update(id,categoriesDto);
        return ResponseEntity.ok(categories);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable int id){
        categoryService.delete(id);
        return ResponseEntity.ok("Xóa Thành CÔng");
    }




































































































}
