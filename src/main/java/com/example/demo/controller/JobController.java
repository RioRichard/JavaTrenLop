package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.StorageService;

@Controller
@RequestMapping("/job/")
public class JobController {

    @GetMapping("form")
    public String form(Model model) {
        model.addAttribute("message", null);

        return "job/form";
    }

    @PostMapping("form")

    public String apply(Model model,

            @RequestParam("fullname") String fullname,
            @RequestParam("cv") MultipartFile cv,
            @RequestParam("photo") MultipartFile photo) {

        if (photo.isEmpty() || cv.isEmpty()) {
            model.addAttribute("message", "Vui lòng chọn file !");
        } else {
            try {
                StorageService.copyFile("./src/main/resources/static/cv", cv);
                StorageService.copyFile("./src/main/resources/static/photo", photo);
                model.addAttribute("fullname",fullname);
                model.addAttribute("photo_name", photo.getOriginalFilename());
                model.addAttribute("cv_name", cv.getOriginalFilename());
                model.addAttribute("cv_type", cv.getContentType());
                model.addAttribute("cv_size", cv.getSize());
                return "job/apply";

            } catch (Exception e) {
                model.addAttribute("message", "Lỗi lưu file !");
            }

        }
        return "job/form";

    }

    
}
