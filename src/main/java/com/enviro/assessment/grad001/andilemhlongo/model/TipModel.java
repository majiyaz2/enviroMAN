package com.enviro.assessment.grad001.andilemhlongo.model;

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
@Table(name = "TIP")
public class TipModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_id_seq")
    @SequenceGenerator(name = "item_id_seq", sequenceName = "item_id_seq", allocationSize = 1)
    @Column(name = "ITEM_ID")
    private Long ID;
    private String title;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CATEGORY_ID")
    @JsonBackReference
    private CategoryModel category;
    private String content; 

    public TipModel(Long ID, String title, CategoryModel category, String content) {
        this.ID = ID;
        this.title = title;
        this.category = category;
        this.content = content;
    }

    public TipModel(){}

    public Long getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public void setID(Long iD) {
        ID = iD;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(CategoryModel category) {
        this.category = category;
    }

    public void setContent(String content) {
        this.content = content;
    }

}