package com.mhlongo.enviro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIP")
public class TipModel {
    @Id
    private Long ID;
    private String title;
    @ManyToOne
    private CategoryModel category;
    private String content; 

    public TipModel(Long ID, String title, CategoryModel category, String content) {
        this.ID = ID;
        this.title = title;
        this.category = category;
        this.content = content;
    }

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

}
