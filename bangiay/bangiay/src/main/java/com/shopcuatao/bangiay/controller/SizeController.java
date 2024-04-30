package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.Service.SizeServiceImpl;
import com.shopcuatao.bangiay.dtos.SizeDTO;
import com.shopcuatao.bangiay.model.Sizes;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("${api.prefix}/size")
@RequiredArgsConstructor
public class SizeController {
    private final SizeServiceImpl sizeService;
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
    public CompletableFuture<ResponseEntity<?>> getAllSize(

    ){
        CompletableFuture<List<Sizes>> futureList = sizeService.getAllSizeAsync();
        return futureList.thenApply(list -> ResponseEntity.ok(list));
    }
    @PutMapping({"/{id}"})
    public ResponseEntity<?> updateSize(@PathVariable int id, @RequestBody SizeDTO sizeDTO){
       Sizes sizes= sizeService.updateSize(id,sizeDTO);
        return ResponseEntity.ok(sizes);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSize(@PathVariable int id,@RequestBody SizeDTO sizeDTO){
        sizeService.deleteSize(id);
        return ResponseEntity.ok("Xóa Thành Công");
    }






























}
