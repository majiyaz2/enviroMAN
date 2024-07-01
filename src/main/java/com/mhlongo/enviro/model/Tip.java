package com.mhlongo.enviro.model;

public class Tip {

    private Long ID;
    private String title;
    private Category category;
    private String content; 

    public Tip(Long ID, String title, Category category, String content) {
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

    public Category getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

}
