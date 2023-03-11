package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.User;




@Controller
@RequestMapping("home")
public class HomeController {
    @Autowired
    private User user;

    @GetMapping(value="index")
    public String get(Model model) {
        model.addAttribute("user", new User("fpoly","thuchocthucnghiep"));
        return "home/index";
    }
    
}
