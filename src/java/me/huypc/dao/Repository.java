/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import me.huypc.dto.ShoppingCart;

/**
 *
 * @author Admin
 */
public class Repository<T> implements IRepository<T> {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String sqlString;

    public Repository(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public PreparedStatement getPstm() {
        return pstm;
    }

    public void setPstm(PreparedStatement pstm) {
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

    @Override
    public void add(T entity) {
        String sql = "";
        try {
            if (entity instanceof ShoppingCart) {
                ShoppingCart cart = (ShoppingCart) entity;
                sql = "INSERT INTO ShoppingCarts VALUES(?,?,?)";
                pstm = con.prepareStatement(sql);
                pstm.setInt(1, cart.getUderId());
                pstm.setInt(2, cart.getProductId());
                pstm.setInt(3, cart.getAmount());
                
                pstm.executeUpdate();
            }
        } catch (Exception e) {
            System.err.println("Error at Repository.add(T entity)\n" + e.toString());
        }
    }

    @Override
    public void update(T entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(T entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            System.err.println("Error while closing connection...");
        }
    }
}
