package com.gproject.zooapp.model;

import java.io.Serializable;

/**************
*  Animal Obj *
* *************/

public class Animal implements Serializable {
    private String title;
    private String description;
    private String imgUrl;
    private String details;
    private int drawableResource;

    // Constructors

    public Animal() {
    }

    public Animal(int drawableResource) {
        this.drawableResource = drawableResource;
    }

    public Animal(String title, String description, String imgUrl, int drawableResource, String details) {
        this.title = title;
        this.description = description;
        this.imgUrl = imgUrl;
        this.drawableResource = drawableResource;
        this.details = details;
    }

    // Getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getDrawableResource() {
        return drawableResource;
    }

    public void setDrawableResource(int drawableResource) {
        this.drawableResource = drawableResource;
    }

    public String getDetails() { return details; }

    public void setDetails(String details) { this.details = details; }
}
