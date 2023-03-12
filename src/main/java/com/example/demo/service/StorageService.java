package com.example.demo.service;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


public class StorageService {
	public static void copyFile(String uploadDir, MultipartFile file) throws Exception {
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }
            InputStream inputStream = file.getInputStream();
            Path filepPath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filepPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            throw e;
        }
    }
	

}
