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
import me.huypc.dto.ShoppingCart;

/**
 *
 * @author Admin
 */
public class CartRepository {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String sqlString;

    public CartRepository(Connection con) {
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

    public void add(ShoppingCart cart) {
        String sql = "";
        try {
            sql = "INSERT INTO ShoppingCarts VALUES(?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, cart.getUderId());
            pstm.setInt(2, cart.getProductId());
            pstm.setInt(3, cart.getAmount());

            pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error at CartRepository.add(ShoppingCart entity)\n" + e.toString());
        }
    }

    public ShoppingCart get(int userId, int productId) {
        ShoppingCart result = null;
        String sql = "";
        try {
            sql = "SELECT * FROM ShoppingCarts WHERE userId = ? AND productId = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, userId);
            pstm.setInt(2, productId);

            rs = pstm.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                int amount = rs.getInt("count");
                
                result = new ShoppingCart(userId, productId);
                result.setId(id);
                result.setAmount(amount);
            }
        } catch (Exception e) {
            System.err.println("Error at CartRepository.get(int userId, int productId)\n" + e.toString());
        }
        return result;
    }
    
    public void update(ShoppingCart cart) {
        String sql = "";
        try {
            sql = "UPDATE ShoppingCarts SET "
                    + "count = ? WHERE userId = ? AND productId = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(2, cart.getUderId());
            pstm.setInt(3, cart.getProductId());
            pstm.setInt(1, cart.getAmount());

            pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error at CartRepository.add(ShoppingCart entity)\n" + e.toString());
        }
    }
    
    public List<ShoppingCart> getAllBy(int userId) {
        List<ShoppingCart> results = new ArrayList();
        try {
            String sql = "SELECT * FROM ShoppingCarts WHERE userId = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, userId);
            
            rs = pstm.executeQuery();
            
            while (rs.next()) {
                int id = rs.getInt("id");
                int productId = rs.getInt("productId");
                int amount = rs.getInt("count");
                ShoppingCart newCart = new ShoppingCart(userId, productId);
                newCart.setId(id);
                newCart.setAmount(amount);
                
                results.add(newCart);
            }
        } catch (Exception e) {
            System.err.println("CartRepository: " + e.toString());
        }
        return results;
    }
    
    public void remove(ShoppingCart cart) {
        String sql = "";
        try {
            sql = "DELETE ShoppingCarts "
                    + "WHERE userId = ? AND productId = ?";
            pstm = con.prepareStatement(sql);
            pstm.setInt(2, cart.getProductId());
            pstm.setInt(1, cart.getUderId());

            pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println("CartReposity: " + e.toString());
        }
    }
    
    public void close() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstm != null) {
                pstm.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            System.out.println("Error while closing connection at UserRepository: " + e.toString());
        }
    }

}
