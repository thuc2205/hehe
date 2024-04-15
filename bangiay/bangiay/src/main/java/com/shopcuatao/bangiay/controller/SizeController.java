package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.dtos.SizeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/size")
public class SizeController {
    @PostMapping("")
    public ResponseEntity<?> createCategory(@RequestBody SizeDTO sizeDTO){
        return ResponseEntity.ok(sizeDTO);
    }
    @GetMapping("")
    public ResponseEntity<?> getAllSize(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok("lay ds thanh cong");
    }
    @PutMapping({"/{id}"})
    public ResponseEntity<?> updateSize(@PathVariable int id, @RequestBody SizeDTO sizeDTO){
        return ResponseEntity.ok("update Thành Công");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSize(@PathVariable int id){
        return ResponseEntity.ok("Xóa Thành Công");
    }






























}
