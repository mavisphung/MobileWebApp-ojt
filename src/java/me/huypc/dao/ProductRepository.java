/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import me.huypc.dto.Product;
import me.huypc.dto.User;

/**
 *
 * @author Admin
 */
public class ProductRepository {
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String sqlString;
    
    public ProductRepository(Connection con) {
        this.con = con;
    }

    
    public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection con) {
        this.con = con;
    }

    public PreparedStatement getStatement() {
        return pstm;
    }

    public void setStatement(PreparedStatement pstm) {
        this.pstm = pstm;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getSqlString() {
        return sqlString;
    }

    public void setSqlString(String sqlString) {
        this.sqlString = sqlString;
    }
    
    public void add(Product product) {
        String sql = "INSERT INTO Products VALUES (?,?,?,?,?,?,?,?)";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setString(1, product.getName());
            pstm.setString(2, product.getImageUrl());
            pstm.setString(3, product.getManufacturer());
            pstm.setString(4, product.getCategory());
            pstm.setString(5, product.getCondition());
            pstm.setInt(6, product.getAvailable());
            pstm.setString(7, product.getDescription());
            pstm.setDouble(8, product.getUnitPrice());
            
            pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error at ProductRepository: " + e.toString());
            System.err.println(e.getMessage());
        }
    }
    
    public List<Product> getAll() {
        List<Product> result = new ArrayList<Product>();
        String sql = "SELECT * FROM Products";
        try {
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String imageUrl = rs.getString("imageUrl");
                String manufacturer = rs.getString("manufacturer");
                String category = rs.getString("category");
                String condition = rs.getString("condition");
                int unitsInStock = rs.getInt("available");
                String description = rs.getString("description");
                double unitPrice = rs.getDouble("unitPrice");
                
                Product obj = new Product(name, imageUrl, manufacturer, category, condition, unitsInStock, description, unitPrice);
                obj.setId(id);
                
                result.add(obj);
            }
        } catch (Exception e) {
            System.err.println("Error at ProductRepository: " + e.toString());
            System.err.println(e.getMessage());
        }
        return result;
    }
    
    public Product get(int id) {
        String sql = "SELECT * FROM Products WHERE id = ?";
        Product result = null;
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String imageUrl = rs.getString("imageUrl");
                String category = rs.getString("category");
                String manufacturer = rs.getString("manufacturer");
                String condition = rs.getString("condition");
                int unitsInStock = rs.getInt("available");
                String description = rs.getString("description");
                int unitPrice = rs.getInt("unitPrice");
                
                result = new Product(name, imageUrl, manufacturer, category, condition, unitsInStock, description, unitPrice);
                result.setId(id);
            }
            
        } catch (Exception e) {
            System.err.println("Error at ProductRepository: " + e.toString());
            System.err.println(e.getMessage());
        }
        
        return result;
    }
    
    public void close() {
        try {
            if (rs != null) rs.close();
            if (pstm != null) pstm.close();
            if (con != null) con.close();
        } catch (Exception e) {
            System.out.println("Error while closing connection at UserRepository: " + e.toString());
        }
    }
    
    
}
