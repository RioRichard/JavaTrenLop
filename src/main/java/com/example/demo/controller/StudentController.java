package com.example.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.model.Student;
import com.example.demo.model.Word;
import com.example.demo.service.StorageService;

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

    @GetMapping("/student/index")
    public String indexEL(Model model) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Phạm Trần Anh Khôi", "khoi.jpg", 1));
        students.add(new Student("Vũ Tuấn Khoa", "khoa.jpg", 2));
        students.add(new Student("Trương Thiên Bảo", "bao.jpg", 3));
        students.add(new Student("Lê Phạm Quốc Thái", "thai.jpg", 4));
        students.add(new Student("Phùng Ngọc Thành", "thanh.jpg", 5));

        model.addAttribute("students", students);
        model.addAttribute("salary", 1000);

        return "student/indexEL";
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

        model.addAttribute("students", students);

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

    @PostMapping("/dict/add")

    public String serveFile(@ModelAttribute(value = "word") Word newWord, HttpServletRequest request, Model model) {

        if (dicts.get(newWord.getEng()) == null) {

            try {
                StorageService.copyFile("./src/main/resources/static/images", newWord.getFile());
            } catch (Exception e) {
                model.addAttribute("message", "Khong the them hinh!!!");

            }

            dicts.put(newWord.getEng(), newWord.getVie());
            return "redirect:/dict";
        } else {
            model.addAttribute("message", "Từ đã tồn tại!!!");
            return "/dict/add";
        }

    }

}
