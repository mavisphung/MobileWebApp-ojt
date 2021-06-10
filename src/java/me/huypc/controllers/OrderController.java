/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.controllers;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import me.huypc.dao.CartRepository;
import me.huypc.dbutil.DbConnection;
import me.huypc.dbutil.SD;
import me.huypc.dto.ShoppingCart;
import me.huypc.dto.User;

/**
 *
 * @author Admin
 */
public class OrderController extends HttpServlet {

    private final String SUCCESS = "products-list.jsp";
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
        String strId = request.getParameter("id");
        HttpSession session = request.getSession(true);
        Connection con = DbConnection.getConnection();
        CartRepository cartRepo = new CartRepository(con);
        try {
            int productId = Integer.parseInt(strId);
            User user = (User) session.getAttribute(SD.LOGIN_USER);
            ShoppingCart cart = cartRepo.get(user.getId(), productId);
            if (cart != null) {
                int amount = cart.getAmount();
                cart.setAmount(amount + 1);
                cartRepo.update(cart);
            } else {
                cart = new ShoppingCart(user.getId(), productId);
                cart.setAmount(1);
                cartRepo.add(cart);
            }
            url = SUCCESS;
        }
        catch (Exception e) {
            log("Error at OrderController: " + e.toString());
            System.err.println(e.getMessage());
        }
        finally {
            cartRepo.close();
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
