package com.mhlongo.enviro.model;

public class Item {


    private Long ID;
    private String name;
    private String description;
    private float weight;
    private String disposal;

    public Item(Long ID, String name, String description, float weight, String disposal) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.disposal = disposal;
    }


    public Long getID() {
        return ID;
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
