package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Records;
import com.example.demo.repositories.RecordRepository;

@Service
public class RecordService {
    @Autowired
    RecordRepository recordRepository;

    public List<Records> getall() {
        return recordRepository.findAll();
    }
    public Records save(Records records) {
        
        return recordRepository.save(records);
    }
}
