package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Departs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Depart {
    @Id
    private String id;
    private String name;
    
}
