package com.enviro.assessment.grad001.andilemhlongo.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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

import com.enviro.assessment.grad001.andilemhlongo.model.CategoryModel;
import com.enviro.assessment.grad001.andilemhlongo.model.ItemModel;
import com.enviro.assessment.grad001.andilemhlongo.repositories.CategoryRepository;
import com.enviro.assessment.grad001.andilemhlongo.repositories.ItemRepository;



@RestController
public class ItemController {
    @Autowired
    protected Environment environment = null;
    private static final Logger log = LoggerFactory.getLogger(ItemController.class);

    @Autowired 
    private ItemRepository itemRepository;

    @Autowired CategoryRepository categoryRepository;
    
    @GetMapping("item")
    public ResponseEntity<List<ItemModel>> allItems(Long id){
         log.info("Item Endpoint");
         return ResponseEntity.ok(itemRepository.findAll());
    }

    @GetMapping("item/{id}")
    public ResponseEntity<Optional<ItemModel>> getItem(@PathVariable Long id){
        log.info("Item ID: "+Long.toString(id));
        return ResponseEntity.ok( itemRepository.findById(id));
    }


    @PostMapping("item/addItem/{itemId}")
    public ResponseEntity<?> addItem(@PathVariable Long itemId, @RequestBody ItemModel item){
        try {
            CategoryModel categoryModel =  categoryRepository.findById(itemId).get();
            item.setCategory(categoryModel);
            return ResponseEntity.ok(itemRepository.save(item));
        } catch (DataIntegrityViolationException|ResourceNotFoundException|NoSuchElementException  e) {
            
            return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("An Item with this name already exists. Or the category does not exist");
            
    }
    }

    @PutMapping("item/{id}")
    public ResponseEntity<ItemModel> updateItem(@PathVariable Long id,@RequestBody ItemModel item){
        ItemModel itemModel = itemRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id));
        itemModel.setDescription(item.getDescription());
        itemModel.setName(item.getName());
        itemModel.setDescription(item.getDescription());
        itemModel.setCategory(item.getCategory());
        ItemModel updatedItemModel = itemRepository.save(itemModel);
        log.info("Updated Category ID: "+Long.toString(updatedItemModel.getID()));
        return ResponseEntity.ok(updatedItemModel);
    }

    

    @DeleteMapping("item/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id){
        try {
            categoryRepository.deleteById(id);
            log.info("Delete ID: "+Long.toString(id));
            return ResponseEntity.ok("Delete ID: "+Long.toString(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("An item with this id does not exist");
        }
        
    }
}
