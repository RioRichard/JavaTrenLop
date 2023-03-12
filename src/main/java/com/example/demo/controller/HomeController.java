package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Users;




@Controller
@RequestMapping("home")
public class HomeController {
    // @Autowired
    // private Users user;

    @GetMapping(value="index")
    public String get(Model model) {
        model.addAttribute("user", new Users("fpoly","thuchocthucnghiep",""));
        return "home/index";
    }
    
}
