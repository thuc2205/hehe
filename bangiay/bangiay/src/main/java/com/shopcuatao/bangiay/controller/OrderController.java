package com.shopcuatao.bangiay.controller;

import com.shopcuatao.bangiay.Service.OrderServiceImpl;
import com.shopcuatao.bangiay.Service.UserServiceImpl;
import com.shopcuatao.bangiay.dtos.OrderDTO;
import com.shopcuatao.bangiay.dtos.UserDTO;
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
@RequestMapping("${api.prefix}/order")
public class OrderController {
    private final OrderServiceImpl orderService;
    @PostMapping("")
    public ResponseEntity<?> createUOrder(@Valid @RequestBody OrderDTO orderDTO, BindingResult result){
        try {
        if(result.hasErrors()){
            List<String> Order = result.getFieldErrors()
                    .stream()
                    .map(FieldError::getDefaultMessage)
                    .toList();
        }
            Orders orders = orderService.createOrder(orderDTO);
        return ResponseEntity.ok(orders);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }
}
