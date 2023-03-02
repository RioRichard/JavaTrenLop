package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Student;

@Controller
public class StudentController {
    
    @GetMapping("/student")
    public String name() {
        
        return "student/index";
    }

    @PostMapping("/student")
    public String post(@ModelAttribute("student") Student student, Model model) {
        
        model.addAttribute("student", student);
        
        return "student/index";
    }

}
