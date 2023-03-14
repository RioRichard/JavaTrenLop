package com.example.demo.model;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "records")
public class Records {
    @Id
    @GeneratedValue
    private int id;

    private boolean type;

    private String reason;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "staffId")
    private Staff staff;
}
