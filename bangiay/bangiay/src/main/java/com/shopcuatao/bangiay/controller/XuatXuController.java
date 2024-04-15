package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.dtos.XuatXuDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.prefix}/xuatXu")
public class XuatXuController {

    @PostMapping("")
    public ResponseEntity<?> createCategory(@RequestBody XuatXuDTO xuatXuDTO){
        return ResponseEntity.ok(xuatXuDTO);
    }
    @GetMapping("")
    public ResponseEntity<?> getAll(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        return ResponseEntity.ok("lay ds thanh cong");
    }
    @PutMapping({"/{id}"})
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody XuatXuDTO xuatXuDTO){
        return ResponseEntity.ok("update Thành Công");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return ResponseEntity.ok("Xóa Thành Công");
    }

}
