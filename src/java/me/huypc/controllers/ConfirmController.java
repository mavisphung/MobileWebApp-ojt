/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import me.huypc.dao.CartRepository;
import me.huypc.dao.OrderRepository;
import me.huypc.dbutil.DbConnection;
import me.huypc.dbutil.SD;
import me.huypc.dto.OrderHeader;
import me.huypc.dto.Product;
import me.huypc.dto.ShoppingCart;
import me.huypc.dto.User;

/**
 *
 * @author Admin
 */
public class ConfirmController extends HttpServlet {

    private final String SUCCESS = "thank-you.html";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SD.ERROR_PAGE;
        String strOrderId = request.getParameter("orderId");
        Connection con = DbConnection.getConnection();
        OrderRepository orderRepo = new OrderRepository(con);
        CartRepository cartRepo = new CartRepository(con);
        HttpSession session = request.getSession();
        List<Product> productList = (List<Product>) session.getAttribute(SD.USER_CARTS);
        User user = (User) session.getAttribute(SD.LOGIN_USER);
        try {
            int orderId = Integer.parseInt(strOrderId);
            OrderHeader header = orderRepo.get(orderId);
            if (header == null) {
                return;
            }
            header.setStatus(SD.STATUS_IN_PROCESS);
            orderRepo.update(header);
            for (Product item : productList) {
                cartRepo.remove(new ShoppingCart(user.getId(), item.getId()));
            }
            url = SUCCESS;
            
        } catch (Exception e) {
            log("CheckoutController: " + e.toString());
        } finally {
            orderRepo.close();
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
