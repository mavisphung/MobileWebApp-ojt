/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.dto;

/**
 *
 * @author Admin
 */
public class ShoppingCart {
    private int id;
    private int uderId;
    private int productId;
    private int amount;

    public ShoppingCart(int uderId, int productId) {
        this.uderId = uderId;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUderId() {
        return uderId;
    }

    public void setUderId(int uderId) {
        this.uderId = uderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    
}
