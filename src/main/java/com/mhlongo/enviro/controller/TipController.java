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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mhlongo.enviro.model.TipModel;
import com.mhlongo.enviro.repositories.TipRepository;


@RestController
public class TipController {
    @Autowired
    protected Environment environment = null;
    private static final Logger log = LoggerFactory.getLogger(TipController.class);

    @Autowired
    TipRepository tipRepository;
    
    @GetMapping("tip")
    public ResponseEntity<List<TipModel>> getAllTips(){
        log.info("Tip Endpoint");
        return ResponseEntity.ok(tipRepository.findAll());
    }

    @GetMapping("tip/{id}")
    public ResponseEntity<Optional<TipModel>> getTip(@PathVariable Long id){
        log.info("Tip ID: "+Long.toString(id));
        return ResponseEntity.ok(tipRepository.findById(id));
    }
    
    @PostMapping("tip/addTip")
    public ResponseEntity<TipModel> addTip(@RequestBody TipModel tip){
        return ResponseEntity.ok(tipRepository.saveAndFlush(tip));
    }
    
    @DeleteMapping("tip/{id}")
    public void deleteTip(@PathVariable Long id){
        tipRepository.deleteById(id);
        log.info("Delete ID: "+Long.toString(id));
    }
}
