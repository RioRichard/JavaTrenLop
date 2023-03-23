package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("order")
public class OrderController {
    @GetMapping("checkout")
    public String checkOut() {
        return "job/apply";
    }
    @GetMapping("list")
    public String list() {
        return "job/apply";
    }
    @GetMapping("detail")
    public String detail() {
        return "job/apply";
    }
    
}
