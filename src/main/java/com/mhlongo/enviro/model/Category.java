package com.mhlongo.enviro.model;

public class Category {

    private Long ID;
    private String name;
    private String description;
    private boolean isRecyclable;

    public Category(Long ID, String name, String description, boolean isRecyclable) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.isRecyclable = isRecyclable;
    }

    public Long getID() {
        return ID;
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
