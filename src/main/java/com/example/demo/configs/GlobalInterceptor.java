package com.example.demo.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.example.demo.repositories.MajorRepository;
import com.example.demo.service.MajorService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class GlobalInterceptor implements HandlerInterceptor {

    @Autowired
    MajorService majorService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        var list = majorService.getAll();
        request.setAttribute("majors", list);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
    
}
