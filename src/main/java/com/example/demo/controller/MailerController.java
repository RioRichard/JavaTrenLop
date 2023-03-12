package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.MailService;

@Controller
@RequestMapping("/mailer/")
public class MailerController {

    @Autowired
    private MailService mailService;

    @PostMapping("form")
    public String send(ModelMap model,

            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("subject") String subject,
            @RequestParam("body") String body) {
        var message = mailService.sendMail(from, to, subject, body);
        model.addAttribute("message",message);
        return "mailer/form";
    }

    @GetMapping("form")
    public String index() {
        return "mailer/form";
    }
}