package com.mhlongo.enviro.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<List<CategoryModel>> logCategory(Long id){
        log.info("Category Endpoint"+ categoryRepository.findAll());
        return ResponseEntity.ok(categoryRepository.findAll());
        
    }

    @GetMapping("category/{id}")
    public ResponseEntity<Optional<CategoryModel>> getCategoryName(@PathVariable Long id){
        log.info("Category ID: "+Long.toString(id));
        return  ResponseEntity.ok(categoryRepository.findById(id));
        
    }
    
    @PostMapping("category/addCategory")
    public ResponseEntity<CategoryModel> addCategoy(@RequestBody CategoryModel category){
        categoryRepository.save(category);
        categoryRepository.flush();
        log.info("Added Category ID: "+Long.toString(category.getID()));
        return ResponseEntity.ok(category);
    }

    @PutMapping("category/{id}")
    public ResponseEntity<CategoryModel> addCategoy(@PathVariable Long id,@RequestBody CategoryModel category){
        CategoryModel categoryModel = categoryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id));
        categoryModel.setDescription(category.getDescription());
        categoryModel.setName(category.getName());
        categoryModel.setRecyclable(category.getIsRecyclable());
        CategoryModel updatedCategoryModel = categoryRepository.save(categoryModel);
        log.info("Added Category ID: "+Long.toString(category.getID()));
        return ResponseEntity.ok(updatedCategoryModel);
    }
    
    @DeleteMapping("category/{id}")
    public void deleteCategoryName(@PathVariable Long id){
        categoryRepository.deleteById(id);
        log.info("Delete ID: "+Long.toString(id));
    }
    
    
}
