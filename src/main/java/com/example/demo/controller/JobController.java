package com.example.demo.controller;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
                copyFile("./src/main/resources/static/cv", cv);
                copyFile("./src/main/resources/static/photo", photo);
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

    private void copyFile(String uploadDir, MultipartFile file) throws Exception {
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            InputStream inputStream = file.getInputStream();
            Path filepPath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filepPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw e;
        }
    }
}
