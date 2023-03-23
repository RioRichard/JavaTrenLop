package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Major;
import com.example.demo.repositories.MajorRepository;

@Service
public class MajorService  {
    
    @Autowired
    private MajorRepository majorRepository;

    
    public List<Major> getAll() {
        return majorRepository.findAll();
    }
}
