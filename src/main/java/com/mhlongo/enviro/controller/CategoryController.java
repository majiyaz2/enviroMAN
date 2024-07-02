package com.mhlongo.enviro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhlongo.enviro.model.CategoryModel;
import com.mhlongo.enviro.repositories.CategoryRepository;

@RestController
public class CategoryController {
    @Autowired
    protected Environment environment = null;
    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @GetMapping("category")
    public void logCategory(Long id){
         log.info("Category Endpoint");
    }

    @GetMapping("category/{id}")
    public CategoryModel getCategoryName(@PathVariable Long id){
        log.info("Category ID: "+Long.toString(id));
        return new CategoryModel(id, null, null, false);
    }
    
    @PostMapping("category/addCategory")
    public CategoryModel addCategoy(CategoryModel category){
        return category;
    }
    
    @DeleteMapping("category/{id}")
    public void deleteCategoryName(@PathVariable Long id){
        log.info("Delete ID: "+Long.toString(id));
    }
    
    
}
