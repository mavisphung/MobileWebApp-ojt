/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.dto;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class Product implements Serializable {
    private int id;
    private String name;
    private String imageUrl;
    private String manufacturer;
    private String category;
    private String condition;
    private int available;
    private String description;
    private double unitPrice;
    private double price;
    public Product() {
        
    }
    
    public Product(String name, String imageUrl, String manufacturer, String category, String condition, int available, String description, double unitPrice) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.manufacturer = manufacturer;
        this.category = category;
        this.condition = condition;
        this.available = available;
        this.description = description;
        this.unitPrice = unitPrice;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", imageUrl=" + imageUrl + ", manufacturer=" + manufacturer + ", category=" + category + ", available=" + available + ", description=" + description + ", unitPrice=" + unitPrice + '}';
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
