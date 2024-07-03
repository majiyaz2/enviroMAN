package com.mhlongo.enviro.model;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_id_seq")
    @SequenceGenerator(name = "category_id_seq", sequenceName = "category_id_seq", allocationSize = 1)
    @Column(name = "CATEGORY_ID")
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
    private boolean isRecyclable;

    public CategoryModel(){}

    public CategoryModel(Long id, String name, String description, boolean isRecyclable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isRecyclable = isRecyclable;
    }


    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
     @JsonManagedReference
    public List<ItemModel> items = new ArrayList<>();
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    public List<TipModel> tips = new ArrayList<>();

    public String getName() {
        return name;
    }

    public boolean getIsRecyclable() {
       return isRecyclable;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRecyclable(boolean isRecyclable) {
        this.isRecyclable = isRecyclable;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public List<TipModel> getTips() {
        return tips;
    }

    public void setTips(List<TipModel> tips) {
        this.tips = tips;
    }
    
}
