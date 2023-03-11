package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    JavaMailSender mailer;

    public String sendMail(String from, String to, String subject, String body) {
        try {
            MimeMessage mail = mailer.createMimeMessage();
            // Sử dụng lớp trợ giúp
            MimeMessageHelper helper = new MimeMessageHelper(mail);
            helper.setFrom(from, from);
            helper.setTo(to);
            helper.setReplyTo(from, from);
            helper.setSubject(subject);
            helper.setText(body, true);
            // Gửi mail
            mailer.send(mail);
            return "Gửi thành công";
        } catch (Exception e) {
            return "Gửi không thành công";
        }
    }
}
