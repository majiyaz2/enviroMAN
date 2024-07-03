package com.mhlongo.enviro.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "Item")
public class ItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
    @SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", allocationSize = 1)
    @Column(name = "ITEM_ID")
    private Long id;
    @Column(unique = true)
    private String name;
    private String description;
    private float weight;
    private String disposal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    @JsonBackReference
    private CategoryModel category;

    public ItemModel(Long id, String name, String description, float weight, String disposal) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.disposal = disposal;
    }

    public ItemModel(){}

    public Long getID() {
        return id;
    }

    public CategoryModel getCategory(){
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getWeight() {
        return weight;
    }

    public String getDisposal() {
        return disposal;
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

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setDisposal(String disposal) {
        this.disposal = disposal;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    

}
