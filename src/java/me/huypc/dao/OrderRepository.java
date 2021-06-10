/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import me.huypc.dbutil.SD;
import me.huypc.dto.OrderHeader;

/**
 *
 * @author Admin
 */
public class OrderRepository {

    private Connection con;
    private PreparedStatement pstm;
    private ResultSet rs;
    private String sqlString;

    public OrderRepository(Connection con) {
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

    public void add(OrderHeader obj) {
        try {
            //insert
            String sql = "INSERT INTO OrderHeaders VALUES(?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, obj.getUserId());
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = format.format(obj.getOrderDate());
            pstm.setString(2, formattedDate);
            pstm.setString(4, obj.getStatus());
            pstm.setDouble(3, obj.getTotal());
            pstm.executeUpdate();

        } catch (Exception e) {
            System.err.println("Error at OrderRepository.insertOrder(OrderHeader obj)\n" + e.toString());
        }
    }

    public List<OrderHeader> getAllBy(int userId) {
        List<OrderHeader> results = new ArrayList();
        String sql = "SELECT * FROM OrderHeaders WHERE userId = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, userId);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                String strDate = rs.getString("orderDate");
                Date orderDate = format.parse(strDate);
                double total = rs.getDouble("total");
                String status = rs.getString("ststus");
                
                OrderHeader objFromDb = new OrderHeader(userId);
                objFromDb.setId(id);
                objFromDb.setOrderDate(orderDate);
                objFromDb.setTotal(total);
                objFromDb.setStatus(status);
                
                results.add(objFromDb);
            }
        } catch (Exception e) {
            System.err.println("Error at OrderRepository.getAllBy(int userId)\n" + e.toString());
        }
        return results;
    }
    
    public OrderHeader get(int userId, Date today, String status) {
        OrderHeader result = null;
        String sql = "SELECT * "
                + "FROM OrderHeaders "
                + "WHERE userId = ? AND orderDate = ? AND status = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, userId);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            String strToday = formatter.format(today);
            pstm.setString(2, strToday);
            pstm.setString(3, SD.STATUS_PENDING);
            
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String strDate = rs.getString("orderDate");
                Date orderDate = formatter.parse(strDate);
                double total = rs.getDouble("total");
                
                OrderHeader objFromDb = new OrderHeader(userId);
                objFromDb.setId(id);
                objFromDb.setOrderDate(orderDate);
                objFromDb.setTotal(total);
                objFromDb.setStatus(status);
                
                result = objFromDb;
            }
        } catch (Exception e) {
            System.err.println("Error at OrderRepository.get(int userId, Date today, String status)\n" + e.toString());
        }
        return result;
    }
    
    public OrderHeader get(int orderId) {
        OrderHeader result = null;
        String sql = "SELECT * "
                + "FROM OrderHeaders "
                + "WHERE id = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, orderId);
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            
            rs = pstm.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("userId");
                String strDate = rs.getString("orderDate");
                Date orderDate = formatter.parse(strDate);
                double total = rs.getDouble("total");
                String status = rs.getString("status");
                
                OrderHeader objFromDb = new OrderHeader(userId);
                objFromDb.setId(id);
                objFromDb.setOrderDate(orderDate);
                objFromDb.setTotal(total);
                objFromDb.setStatus(status);
                
                result = objFromDb;
            }
        } catch (Exception e) {
            System.err.println("Error at OrderRepository.get(int orderId)\n" + e.toString());
        }
        return result;
    }
    
    public void update(OrderHeader obj) {
        String sql = "UPDATE OrderHeaders SET "
                + "orderDate = ?, total = ?, status = ? "
                + "WHERE userId = ? AND id = ?";
        try {
            pstm = con.prepareStatement(sql);
            pstm.setInt(4, obj.getUserId());
            pstm.setInt(5, obj.getId());
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String formattedDate = format.format(obj.getOrderDate());
            pstm.setString(1, formattedDate);
            pstm.setDouble(2, obj.getTotal());
            pstm.setString(3, obj.getStatus());

            pstm.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error at OrderRepository.update(OrderHeader obj)\n" + e.toString());
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
