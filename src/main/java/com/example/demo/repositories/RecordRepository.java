package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Records;

@Repository
public interface RecordRepository extends JpaRepository<Records,Integer>{
    
}
