package com.mhlongo.enviro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class CategoryModel {
    @Id
    private Long id;
    private String name;
    private String description;
    private boolean isRecyclable;

    public CategoryModel(Long id, String name, String description, boolean isRecyclable) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isRecyclable = isRecyclable;
    }

    public Long getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Object getIsRecyclable() {
       return isRecyclable;
    }

    public String getDescription() {
        return description;
    }

}
