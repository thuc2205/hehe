package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.Service.OrderDetailServiceImpl;
import com.shopcuatao.bangiay.dtos.OrderDTO;
import com.shopcuatao.bangiay.dtos.OrderDetailDTO;
import com.shopcuatao.bangiay.model.Orders;
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
@RequiredArgsConstructor
@RequestMapping("${api.prefix}/orderdetail")
public class OrderDetailController {

    private final OrderDetailServiceImpl orderDetailService;

    @PostMapping("")
    public ResponseEntity<?> createUOrder(@Valid @RequestBody OrderDetailDTO orderDetailDTO, BindingResult result){
        try {
            if(result.hasErrors()){
                List<String> Order = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
            }
            orderDetailService.createOrder(orderDetailDTO);
            return ResponseEntity.ok(orderDetailDTO);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }
}
