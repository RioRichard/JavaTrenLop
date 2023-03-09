package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    public Student(String name,String img,int lv){
        this.name = name;
        this.img = img;
        this.level=lv;
    }
    private int level;
    private String name;
    private String mark;
    private String major;
    private String nationality;
    private String title;
    private String favorite;
    private String img;
}
