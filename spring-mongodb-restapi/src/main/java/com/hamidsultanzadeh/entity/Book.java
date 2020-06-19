package com.hamidsultanzadeh.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document
public class Book {

    @Id
    private String id;
    private String name;
    private String author;
    private HashMap features;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public HashMap getFeatures() {
        return features;
    }

    public void setFeatures(HashMap features) {
        this.features = features;
    }
}
