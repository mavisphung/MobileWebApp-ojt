/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.dao;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface IRepository<T> {
    void add(T entity);
    void update(T entity);
    void remove(T entity);
    T get(int id);
    List<T> getAll();
    
}
