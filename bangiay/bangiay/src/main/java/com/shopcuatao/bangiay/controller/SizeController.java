package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.Service.SizeService;
import com.shopcuatao.bangiay.dtos.SizeDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/size")
@RequiredArgsConstructor
public class SizeController {
    private final SizeService sizeService;
    @PostMapping("")
    public ResponseEntity<?> createCategory(@Valid  @RequestBody SizeDTO sizeDTO, BindingResult result){
        if(result.hasErrors()){
            List<String> errMessage = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
        }
        sizeService.createSize(sizeDTO);
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
