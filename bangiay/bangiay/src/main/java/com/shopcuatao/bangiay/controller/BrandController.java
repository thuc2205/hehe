package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.dtos.BrandDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/brand")
public class BrandController {

    @PostMapping("")
    public ResponseEntity<?> createBrand(@RequestBody BrandDTO brandDTO){
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
        return ResponseEntity.ok("thanh cong");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return ResponseEntity.ok("thanh COng");
    }

}
