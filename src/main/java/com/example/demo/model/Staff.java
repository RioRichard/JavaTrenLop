package com.example.demo.model;

import java.sql.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "staffs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Staff {
    @Id
    private String id;
    private String name;
    private boolean gender;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthDay;
    private String phone;
    private float salary;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "DepartId")
    private Depart depart;

    @OneToMany(mappedBy = "staff", fetch = FetchType.EAGER)
    private List<Records> records;

    @Transient
    private Report report;

    public Report getReport(){
        var plus = 0;
        var minus = 0;
        for (Records record : records) {
            if (record.isType()) {
                plus++;
            } else {
                minus++;
            }
        }
        return new Report(plus, minus, plus-minus);
    }
    


}
