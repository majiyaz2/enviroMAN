package com.mhlongo.enviro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Item")
public class ItemModel {

    @Id
    private Long id;
    private String name;
    private String description;
    private float weight;
    private String disposal;

    public ItemModel(Long id, String name, String description, float weight, String disposal) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.disposal = disposal;
    }


    public Long getID() {
        return id;
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

}
