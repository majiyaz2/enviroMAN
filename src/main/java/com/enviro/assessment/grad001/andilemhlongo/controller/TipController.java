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
import com.enviro.assessment.grad001.andilemhlongo.model.TipModel;
import com.enviro.assessment.grad001.andilemhlongo.repositories.CategoryRepository;
import com.enviro.assessment.grad001.andilemhlongo.repositories.TipRepository;




@RestController
public class TipController {
    @Autowired
    protected Environment environment = null;
    private static final Logger log = LoggerFactory.getLogger(TipController.class);

    @Autowired
    private TipRepository tipRepository;
    @Autowired 
    private CategoryRepository categoryRepository;
    
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
    
    @PostMapping("tip/addTip/{tipId}")
    public ResponseEntity<?> addTip(@PathVariable Long tipId, @RequestBody TipModel tip){
        try {
            CategoryModel categoryModel =  categoryRepository.findById(tipId).get();
            tip.setCategory(categoryModel);
            return ResponseEntity.ok(tipRepository.save(tip));
        } catch (DataIntegrityViolationException|ResourceNotFoundException|NoSuchElementException  e) {
            
            return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body("An Item with this name already exists. Or the category does not exist");
            
        }
        
    }

    @PutMapping("tip/{id}")
    public ResponseEntity<TipModel> addCategoy(@PathVariable Long id,@RequestBody TipModel tip){
        TipModel tipModel = tipRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id));

        tipModel.setID(tip.getID());
        tipModel.setContent(tip.getContent());
        tipModel.setCategory(tip.getCategory());
        tipModel.setTitle(tipModel.getTitle());

        TipModel updatedTipModel = tipRepository.save(tipModel);
        log.info("Updated Category ID: "+Long.toString(updatedTipModel.getID()));
        return ResponseEntity.ok(updatedTipModel);
    }

    
    @DeleteMapping("tip/{id}")
    public ResponseEntity<?> deleteTip(@PathVariable Long id){
        try {
            tipRepository.deleteById(id);
            log.info("Delete ID: "+Long.toString(id));
            return ResponseEntity.ok("Delete ID: "+Long.toString(id));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body("A tip with this id does not exist");
        }
    }
}
