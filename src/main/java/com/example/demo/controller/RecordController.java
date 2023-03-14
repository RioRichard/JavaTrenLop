package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import com.example.demo.model.Records;
import com.example.demo.service.RecordService;

@Controller
@RequestMapping("record")
public class RecordController {

    @Autowired
    private RecordService recordService;

    @GetMapping(value = "insert")
    public String insert(Model model) {
        model.addAttribute("records", new Records());
        return "record/insert";
    }

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public String insert(Model model,

            @ModelAttribute("record") Records record) {

        try {
            record.setDate(new Date());

            recordService.save(record);
            model.addAttribute("message", "Thêm mới thành công !");
        } catch (Exception e) {
           
            model.addAttribute("message", "Thêm mới thất bại !");
        } 
        return insert(model);
    }

}
