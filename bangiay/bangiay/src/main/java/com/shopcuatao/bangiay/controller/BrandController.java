package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.Service.BrandServiceImpl;
import com.shopcuatao.bangiay.dtos.BrandDTO;
import com.shopcuatao.bangiay.model.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/brand")
@RequiredArgsConstructor
public class BrandController {

    private final BrandServiceImpl brandService;

    @PostMapping("")
    public ResponseEntity<?> createBrand(@RequestBody BrandDTO brandDTO, BindingResult result){
        if(result.hasErrors()){
            List<String> err = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
        }
        brandService.create(brandDTO);
        return ResponseEntity.ok(brandDTO);
    }
    @GetMapping("")
    public ResponseEntity<?>getAllBrand(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok("brandDTO");
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBrand(@PathVariable int id,@RequestBody BrandDTO brandDTO){
        Brand brand = brandService.update(id,brandDTO);
        return ResponseEntity.ok(brand);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        brandService.delete(id);
        return ResponseEntity.ok("thanh COng");
    }

}
