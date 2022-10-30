package com.krasnyukov.kyrsovoiProject.models;

public class Product {
    private int id;
    private String name;
    private String category;
    private float price;
    private String description;
    private String producingCountry;

    public Product() {}

    public Product(int id, String name, String category, float price, String description, String producingCountry){
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.producingCountry = producingCountry;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProducingCountry() {
        return producingCountry;
    }

    public void setProducingCountry(String producingCountry) {
        this.producingCountry = producingCountry;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
