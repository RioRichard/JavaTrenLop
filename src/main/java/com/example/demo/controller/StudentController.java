package com.example.demo.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Student;
import com.example.demo.model.Word;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class StudentController {

    private final static Map<String, String> dicts;
    static {
        dicts = new HashMap<>();
        dicts.put("Hello", "Xin chào");
        dicts.put("Love", "Yêu");
        dicts.put("Computer", "Máy tính");
        dicts.put("Remember", "Nhớ");
        dicts.put("Artificial", "Nhân tạo");
    }

    @GetMapping("/student")
    public String name(@ModelAttribute("student") Student student, Model model) {
        model.addAttribute("student", student);
        return "student/index";
    }

    @GetMapping("/index2")
    public String indexEL2(Model model) {
        List<Student> students = new ArrayList<>();
        Student sv1 = new Student("Phạm Minh Tuấn", 5.5, "Ứng dụng phần mềm");
        Student sv2 = new Student("Nguyễn Thị Kiều Oanh", 9.5, "Thiết kế trang web");
        Student sv3 = new Student("Lê Phạm Tuấn Kiệt", 3.5, "Thiết kế trang web");

        students.add(sv1);
        students.add(sv2);
        students.add(sv3);

        model.addAttribute("students",students);


        return "student/index2";
    }



    @PostMapping("/student")
    public String post(@ModelAttribute("student") Student student, Model model) {

        model.addAttribute("student", student);
        String[] major = { "Công nghệ phần mềm", "Thiết kế web" };
        model.addAttribute("majors", major);
        return "student/index";
    }

    @PostMapping(value = "/check")
    public String postWordString(@ModelAttribute("word") Word word, Model model) {
        model.addAttribute("word", word);
        String[] major = { "Công nghệ phần mềm", "Thiết kế web" };
        model.addAttribute("majors", major);

        return "student/addWord";

    }

    @GetMapping(value = "/dict")
    public String getWord(Model model) {
        // model.addAttribute("word", word);
        // model.addAttribute("message", "");
        model.addAttribute("dict", dicts);

        return "student/dict";

    }

    @GetMapping(value = "/dict/{word}")
    public String getWord(@PathVariable(name = "word") String name, Model model) {
        // model.addAttribute("word", word);
        String message = dicts.get(name);
        if (message == null)
            message = "Không có từ này!!!";
        model.addAttribute("message", message);

        return "student/result";

    }

    @GetMapping("dict/add")
    public String addword(Model model) {
        model.addAttribute("message", "");

        return "student/addword";
    }

    // @PostMapping("/dict/add")

    // public String serveFile(@ModelAttribute(value = "word") Word newWord, HttpServletRequest request, Model model) {

    //     if (dicts.get(newWord.getEng()) == null) {
    //         MultipartFile img = newWord.getFile();
    //         String fileName=StringUtils.cleanPath(img.getOriginalFilename());
    //         String uploadDir="./src/main/resources/static/Image/ImageProduct/";

    //         Path uploadPath=Paths.get(uploadDir);
    
    //         if(!Files.exists(uploadPath))
    //         {
    //             Files.createDirectories(uploadPath);
    //         }
    //         try {
    //             InputStream inputStream=img.getInputStream();
    //         Path filepPath=uploadPath.resolve(fileName);
    //         copy = Files.copy(inputStream,filepPath, StandardCopyOption.REPLACE_EXISTING);

    //         dicts.put(newWord.getEng(), newWord.getVie());
    //         return "redirect:/dict";
    //     } else {
    //         model.addAttribute("message", "Từ đã tồn tại!!!");
    //         return "/dict/add";
    //     }

    // }

}
