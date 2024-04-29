package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.Service.VoucherServiceImpl;
import com.shopcuatao.bangiay.dtos.VoucherDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${api.prefix}/voucher")
@RequiredArgsConstructor
public class VoucherController {
    private final VoucherServiceImpl voucherService;
    @PostMapping("")
    public ResponseEntity<?> createVoucher(@Valid @RequestBody VoucherDTO voucherDTO, BindingResult result){
        if(result.hasErrors()){
            List<String> errVoucher = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
        }
        try {
            voucherService.create(voucherDTO);
            return ResponseEntity.ok(voucherDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }
}
