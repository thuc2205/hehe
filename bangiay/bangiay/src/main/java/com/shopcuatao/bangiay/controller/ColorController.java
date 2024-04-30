package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.Service.ColorServiceImpl;
import com.shopcuatao.bangiay.dtos.ColorDTO;
import com.shopcuatao.bangiay.model.Colors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("${api.prefix}/color")
@RequiredArgsConstructor
public class ColorController {

    private final ColorServiceImpl colorService;
    @PostMapping("")
    public ResponseEntity<?> createColor(@RequestBody ColorDTO colorDTO, BindingResult result){
        if(result.hasErrors()){
            List<String> errCreateColor = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
        }
        colorService.create(colorDTO);
        return ResponseEntity.ok(colorDTO);
    }
    @GetMapping("")
    public CompletableFuture<?> getAll(Model model) {
        CompletableFuture<List<Colors>> listCompletableFuture = colorService.getAll();
        return listCompletableFuture.thenApply(list -> ResponseEntity.ok(listCompletableFuture));
    }




    @PutMapping({"/{id}"})
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody ColorDTO colorDTO){
        Colors colors = colorService.update(id,colorDTO);
        return ResponseEntity.ok(colors);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        colorService.delete(id);
        return ResponseEntity.ok("Xóa Thành Công");
    }
}
