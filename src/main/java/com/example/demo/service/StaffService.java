package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Staff;
import com.example.demo.repositories.StaffRepository;

@Service
public class StaffService {
    @Autowired
    StaffRepository staffRepository;

    public List<Staff> getAll() {
        return staffRepository.findAll();
    }
}
