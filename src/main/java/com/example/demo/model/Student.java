package com.example.demo.model;

import java.io.File;

import org.springframework.data.annotation.Id;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    public Student(String group, String classes, String major,  String subject, Float grade){
        this.group=group;
        this.classes=classes;
        this.major=major;
        this.subject=subject;
        this.grade=grade;
    }

    public Student(String name, double mark, String major) {
        
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Tên nhóm không thể trống")
    private String group;

    @NotEmpty(message = "Lớp không thể trống")
    private String classes;

    private String major;

    @NotEmpty(message = "Môn học không thể trống")
    private String subject;
    
    @NotNull(message = "Điểm không thể trống")
    @Min(value = 0, message = "Điểm không thể bé hơn 0")
    @Max(value = 10, message = "Điểm không thể lớn hơn 10")
    private Float grade;


    private MultipartFile img;
}
