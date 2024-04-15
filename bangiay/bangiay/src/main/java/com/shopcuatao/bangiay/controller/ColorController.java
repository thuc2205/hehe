package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.dtos.ColorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/color")
public class ColorController {
    @PostMapping("")
    public ResponseEntity<?> createColor(@RequestBody ColorDTO colorDTO){
        return ResponseEntity.ok(colorDTO);
    }
    @GetMapping("")
    public ResponseEntity<?> getAll(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok("lay ds thanh cong");
    }
    @PutMapping({"/{id}"})
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody ColorDTO colorDTO){
        return ResponseEntity.ok("update Thành Công");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return ResponseEntity.ok("Xóa Thành Công");
    }
}
