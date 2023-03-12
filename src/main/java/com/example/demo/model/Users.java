package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// @Table(appliesTo = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Users {
    @Id
    private String username;
    @Column(name = "password")
    private String pass;
    private String fullname;
}
