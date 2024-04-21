package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.Service.XuatXuServiceImpl;
import com.shopcuatao.bangiay.dtos.XuatXuDTO;
import com.shopcuatao.bangiay.model.XuatXu;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("${api.prefix}/xuatXu")
@RequiredArgsConstructor
public class XuatXuController {

    private final XuatXuServiceImpl xuatXuService;

    @PostMapping("")
    public ResponseEntity<?> createXuatXu(@RequestBody XuatXuDTO xuatXuDTO, BindingResult result){
        if(result.hasErrors()){
            List<String> errCreateXuatXu = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
        }
        xuatXuService.create(xuatXuDTO);
        return ResponseEntity.ok(xuatXuDTO);
    }
    @GetMapping("")
    public CompletableFuture<ResponseEntity<?>> getAll(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ){
        CompletableFuture<List<XuatXu>> listCompletableFuture = xuatXuService.getAll();
        return listCompletableFuture.thenApply(l -> ResponseEntity.ok(listCompletableFuture));
    }
    @PutMapping({"/{id}"})
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody XuatXuDTO xuatXuDTO){
        XuatXu xuatXu = xuatXuService.update(id,xuatXuDTO);
        return ResponseEntity.ok(xuatXu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        xuatXuService.delete(id);
        return ResponseEntity.ok("Xóa Thành Công");
    }

}
