/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import me.huypc.dto.User;

/**
 *
 * @author Admin
 */
public class UserRepository {
    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String sqlString;
    
    public UserRepository(Connection con) {
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
    
    
    public User getLoggedInUser(String username, String password) {
        User result = null;
        try {
//            pstm = con.prepareStatement(sqlString);
            rs = pstm.executeQuery();
            
            if (rs.next()) {
                int id = rs.getInt("id");
                String fullName = rs.getString("fullName");
                int roleId = rs.getInt("roleId");
                String email = rs.getString("email");
                String phone = rs.getString("phoneNumber");
                
                result = new User(id);
                result.setUsername(username);
                result.setPassword(password);
                result.setFullName(fullName);
                result.setPhoneNumber(phone);
                result.setEmail(email);
                result.setRoleId(roleId);
            }
            
        } catch (Exception e) {
            System.out.println("Error at UserRepository: " + e.toString());
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
