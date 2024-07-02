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

import com.mhlongo.enviro.model.Tip;


@RestController
public class TipController {
    @Autowired
    protected Environment environment = null;
    private static final Logger log = LoggerFactory.getLogger(TipController.class);
    
    @GetMapping("tip")
    public void logCategory(Long id){
         log.info("Tip Endpoint");
    }

    @GetMapping("tip/{id}")
    public Tip getCategoryName(@PathVariable Long id){
        log.info("Tip ID: "+Long.toString(id));
        return new Tip(id, null, null, null);
    }
    
    @PostMapping("tip/addTip")
    public Tip addTip(Tip tip){
        return tip;
    }
    
    @DeleteMapping("tip/{id}")
    public void deleteCategoryName(@PathVariable Long id){
        log.info("Delete ID: "+Long.toString(id));
    }
}
