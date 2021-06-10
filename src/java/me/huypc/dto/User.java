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
public class User {
    private int id;
    private String username;
    private String fullName;
    private String password;
    private int roleId;
    private String email;
    private String phoneNumber;

    public User() {
        
    }

    public User(int id) {
        this.id = id;
    }
    
    public User(String username, String fullName, String password, int roleId, String email, String phoneNumber) {
        this.username = username;
        this.fullName = fullName;
        this.password = password;
        this.roleId = roleId;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}
