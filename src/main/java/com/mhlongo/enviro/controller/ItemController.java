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

import com.mhlongo.enviro.model.ItemModel;


@RestController
public class ItemController {
    @Autowired
    protected Environment environment = null;
    private static final Logger log = LoggerFactory.getLogger(ItemController.class);
    
    @GetMapping("item")
    public void logCategory(Long id){
         log.info("Item Endpoint");
    }

    @GetMapping("item/{id}")
    public ItemModel getCategoryName(@PathVariable Long id){
        log.info("Item ID: "+Long.toString(id));
        return new ItemModel(id, null, null, 0, null);
    }

    @PostMapping("item/addItem")
    public ItemModel addItem(ItemModel item){
        return item;
    }

    @DeleteMapping("item/{id}")
    public void deleteItem(@PathVariable Long id){
        log.info("Delete ID: "+Long.toString(id));
        
    }
}
