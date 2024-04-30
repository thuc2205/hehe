package com.shopcuatao.bangiay.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${api.prefix}/test")
@RequiredArgsConstructor
public class test {
    @GetMapping("")
    public String getChu(Model model){
        // Truyền từ "hello4" vào model
        model.addAttribute("message", "hello4");

        // Trả về tên của trang HTML muốn hiển thị
        return "index";
    }
}
