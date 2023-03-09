package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private String name;
    private Double unitPrice;
    private Double discount;

    public Double getNewPrice(){
        return unitPrice*(1-discount);
    }
}
