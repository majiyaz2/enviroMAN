package com.mhlongo.enviro.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mhlongo.enviro.Category;

@RestController
public class CategoryController {
    @Autowired
    protected Environment environment = null;
    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    
    @GetMapping("category")
    public void logCategory(Long id){
         log.info("Category Endpoint");
    }

    @GetMapping("category/{id}")
    public Category getCategoryName(@PathVariable Long id){
        log.info(Long.toString(id));
        return new Category(id, null, null, false);
    }


}
