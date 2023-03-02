package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.User;

@Controller

public class LoginController {

    private final String prefix = "/account";

    @GetMapping(value = "/")
    public String getMethodName() {
        return prefix + "/login";
    }

    @PostMapping("/")
    public String loginHandle(@ModelAttribute("user") User user, Model model) {
        System.out.println(user.getPass() + "=============" + user.getUsername());
        if (user.getPass().equals("admin") && user.getUsername().equals("admin")) {
            model.addAttribute("success", "Thành công");

        } else
            model.addAttribute("error", "Thất bại");

        return prefix + "/login";

    }

}
