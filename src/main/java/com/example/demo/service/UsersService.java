package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Users;
import com.example.demo.repositories.UsersRepository;

@Service
public class UsersService {
    
    @Autowired
    UsersRepository usersRepository;

    public List<Users> getAllUser() {
        return usersRepository.findAll();
    }

    public void addUser(Users user) {
        usersRepository.save(user);
        
    }
}
