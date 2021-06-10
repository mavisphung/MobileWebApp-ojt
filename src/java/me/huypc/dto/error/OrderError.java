/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.dto.error;

/**
 *
 * @author Admin
 */
public class OrderError {
    private String idError;
    private String countError;
    private String message;

    public OrderError() {
        
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
    public OrderError(String idError, String countError) {
        this.idError = idError;
        this.countError = countError;
    }

    public String getIdError() {
        return idError;
    }

    public void setIdError(String idError) {
        this.idError = idError;
    }

    public String getCountError() {
        return countError;
    }

    public void setCountError(String countError) {
        this.countError = countError;
    }
    
    
    
}
