package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.StaffService;

@Controller
@RequestMapping("staff")
public class StaffController {
    
    @Autowired
    private StaffService staffService;

    @GetMapping("index")
    public String getAll(Model model) {
        model.addAttribute("staff", staffService.getAll());
        return "staff/index";
    }
    @GetMapping("report")
    public String index(Model model) {

        model.addAttribute("staff",staffService.getAll());
        return "staff/report";
    }
}
