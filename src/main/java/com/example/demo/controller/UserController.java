package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Users;
import com.example.demo.service.UsersService;


@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UsersService usersService;

    @GetMapping(value="index")
    public String getAll(Model model) {
        model.addAttribute("users", usersService.getAllUser());
        return "user/index";
    }
    @GetMapping(value="insert")
    public String viewInsert(Model model) {
        // model.addAttribute("users", usersService.getAllUser());
        return "user/insert";
    }

    @PostMapping("insert")
    public String insert(@ModelAttribute("users") Users user, Model model) {
        try {
            usersService.addUser(user);
        } catch (Exception e) {
            model.addAttribute("message", e.toString());
        }
        return getAll(model);
    }

    @GetMapping("login")
    public String login() {
        return "account/login";
    }
    @GetMapping("logoff")
    public String logoff() {
        return "job/form";
    }
    @GetMapping("register")
    public String register() {
        return "job/form";
    }
    @GetMapping("activate")
    public String activate() {
        return "job/form";
    }
    @GetMapping("forgot-password")
    public String forgot() {
        return "job/form";
    }
    @GetMapping("change-password")
    public String change() {
        return "job/form";
    }
    @GetMapping("edit-profile")
    public String edit() {
        return "job/form";
    }
    
    
}
