/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class MainController extends HttpServlet {

    private final String ERROR = "error.html";
    private final String LOGIN_CONTROLLER = "LoginController";
    private final String LOGOUT_CONTROLLER = "LogoutController";
    private final String PRODUCT_CONTROLLER = "ProductController";
    private final String DETAIL_CONTROLLER = "DetailController";
    private final String ORDER_CONTROLLER = "OrderController";
    private final String CART_CONTROLLER = "CartController";
    private final String REMOVE_CONTROLLER = "RemoveController";
    private final String PLUS_CONTROLLER = "Plus";
    private final String MINUS_CONTROLLER = "Minus";
    private final String CHECKOUT_CONTROLLER = "CheckoutController";
    private final String CONFIRM_CONTROLLER = "ConfirmController";

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
        String action = request.getParameter("action");
        String url = ERROR;
        try {
            switch (action) {
                case "Sign in":
                    url = LOGIN_CONTROLLER;
                    break;
                case "Log out":
                    url = LOGOUT_CONTROLLER;
                    break;
                case "Add Product":
                    url = PRODUCT_CONTROLLER;
                    break;
                case "Detail":
                    url = DETAIL_CONTROLLER;
                    break;
                case "Order Now":
                    url = ORDER_CONTROLLER;
                    break;
                case "ViewCart":
                    url = CART_CONTROLLER;
                    break;
                case "RemoveCart":
                    url = REMOVE_CONTROLLER;
                    break;
                case "Plus":
                    url = PLUS_CONTROLLER;
                    break;
                case "Minus":
                    url = MINUS_CONTROLLER;
                    break;
                case "CheckOut":
                    url = CHECKOUT_CONTROLLER;
                    break;
                case "Confirm":
                    url = CONFIRM_CONTROLLER;
                    break;
            }
            
        } catch (Exception ex) {
            log("Error at MainController: " + ex.toString());
        } finally {
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
