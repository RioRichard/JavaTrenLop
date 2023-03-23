package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Categories;
import com.example.demo.repositories.CategoriesRepositoy;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepositoy categoriesRepositoy;

    public List<Categories> getAll() {
        return categoriesRepositoy.findAll();
    }

    public void insert(Categories categories) {
        categoriesRepositoy.save(categories);
    }

    public void update(int id ,Categories entity) {
       entity.setId(id);
       categoriesRepositoy.save(entity);

    }

    public Categories getId(int id ) {
        return categoriesRepositoy.findById(id).get();
 
     }
}
