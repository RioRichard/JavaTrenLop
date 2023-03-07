package com.example.demo.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Word {
    private String eng;
    private String vie;
    private String urlPic;
    private MultipartFile file;

}
