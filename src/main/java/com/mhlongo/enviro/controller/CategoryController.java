package com.mhlongo.enviro.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.mhlongo.enviro.model.CategoryModel;
import com.mhlongo.enviro.model.ItemModel;
import com.mhlongo.enviro.repositories.CategoryRepository;

@RestController
public class CategoryController {
    @Autowired
    protected Environment environment = null;
    private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @GetMapping("category")
    public ResponseEntity<List<CategoryModel>> getAllCategories(Long id){
        log.info("Category Endpoint"+ categoryRepository.findAll());
        return ResponseEntity.ok(categoryRepository.findAll());
        
    }

    @GetMapping("category/{id}")
    public ResponseEntity<?> getCategoryName(@PathVariable Long id){
        log.info("Category ID: "+Long.toString(id));
        try {
            return  ResponseEntity.ok(categoryRepository.findById(id));
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("A category with this id does not exist");
        }
        
    }
    
    @PostMapping("category/addCategory")
    public ResponseEntity<?> addCategoy(@RequestBody CategoryModel category){
        List<ItemModel> items = category.getItems();
       

        try {
            if(items != null){
                for(ItemModel itemModel : items){
                    itemModel.setCategory(category);
                }
            }
            CategoryModel savedCategory = categoryRepository.save(category);
            log.info("Added Category ID: "+Long.toString(category.getId()));
            return ResponseEntity.ok(savedCategory);
            
        } catch (DataIntegrityViolationException e) {
                return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("A category with this name already exists.");
        }
       
    }

    @PutMapping("category/{id}")
    public ResponseEntity<?> addCategory(@PathVariable Long id,@RequestBody CategoryModel category){
        try {
            CategoryModel categoryModel;
            categoryModel = categoryRepository.findById(id).get();
            categoryModel.setDescription(category.getDescription());
            categoryModel.setName(category.getName());
            categoryModel.setRecyclable(category.getIsRecyclable());
             
            log.info("Updated Category ID: "+Long.toString(categoryModel.getId()));
            return ResponseEntity.ok(categoryRepository.save(categoryModel));
           
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("A category with this id does not exist");
        }
        
    }
    
    @DeleteMapping("category/{id}")
    public ResponseEntity<String> deleteCategoryName(@PathVariable Long id){
        try {
            categoryRepository.deleteById(id);
            log.info("Delete ID: "+Long.toString(id));
            return ResponseEntity.ok("Delete ID: "+Long.toString(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("A category with this id does not exist");
        }
    }
    
    
}
