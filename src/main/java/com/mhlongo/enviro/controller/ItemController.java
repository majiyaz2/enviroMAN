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
import com.mhlongo.enviro.model.ItemModel;
import com.mhlongo.enviro.repositories.CategoryRepository;
import com.mhlongo.enviro.repositories.ItemRepository;


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

    @PostMapping("item/addItem/{categoryId}")
    public ResponseEntity<ItemModel> addItem(@PathVariable Long categoryId, @RequestBody ItemModel item){
        CategoryModel categoryModel =  categoryRepository.findById(categoryId)
        .orElseThrow(() -> new ResourceNotFoundException("Please specify a valid category: " + categoryId));
        item.setCategory(categoryModel);
        return ResponseEntity.ok(itemRepository.save(item));
    }

    @PutMapping("item/{id}")
    public ResponseEntity<ItemModel> addCategoy(@PathVariable Long id,@RequestBody ItemModel item){
        ItemModel itemModel = itemRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id));
        itemModel.setDescription(item.getDescription());
        itemModel.setName(item.getName());
        itemModel.setDescription(item.getDescription());
        ItemModel updatedItemModel = itemRepository.save(itemModel);
        log.info("Updated Category ID: "+Long.toString(updatedItemModel.getID()));
        return ResponseEntity.ok(updatedItemModel);
    }

    

    @DeleteMapping("item/{id}")
    public void deleteItem(@PathVariable Long id){
        itemRepository.deleteById(id);
        log.info("Delete ID: "+Long.toString(id));
        
    }
}
