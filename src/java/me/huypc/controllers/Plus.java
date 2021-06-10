/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import me.huypc.dao.CartRepository;
import me.huypc.dao.ProductRepository;
import me.huypc.dbutil.DbConnection;
import me.huypc.dbutil.SD;
import me.huypc.dto.Product;
import me.huypc.dto.ShoppingCart;
import me.huypc.dto.User;
import me.huypc.dto.error.OrderError;

/**
 *
 * @author Admin
 */
public class Plus extends HttpServlet {

    private final String SUCCESS = "cart.jsp";

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
        String url = SUCCESS;
        String strProductId = request.getParameter("productId");
        Connection con = DbConnection.getConnection();
        CartRepository cartRepo = new CartRepository(con);
        ProductRepository prodRepo = new ProductRepository(con);
        HttpSession session = request.getSession();
        try {
            int productId = Integer.parseInt(strProductId);
            User user = (User) session.getAttribute(SD.LOGIN_USER);
            //xử lí trừ
            ShoppingCart cartFromDb = cartRepo.get(user.getId(), productId);
            if (cartFromDb == null) {
                OrderError error = new OrderError();
                error.setMessage("You didn't order any thing yet");
                request.setAttribute(SD.ERROR_ENTITY, error);
                return;
            }

            int count = cartFromDb.getAmount() + 1;
            cartFromDb.setAmount(count);
            cartRepo.update(cartFromDb);

            List<ShoppingCart> cartList = cartRepo.getAllBy(user.getId());
            List<Product> prodList = new ArrayList();

            for (ShoppingCart cart : cartList) {
                Product productInCart = prodRepo.get(cart.getProductId());
                productInCart.setPrice(0);
                productInCart.setAvailable(cart.getAmount());

                double price = productInCart.getUnitPrice() * productInCart.getAvailable();
                productInCart.setPrice(price);
                prodList.add(productInCart);
            }

            session.setAttribute(SD.USER_CARTS, prodList);

            url = SUCCESS;
        } catch (Exception e) {
            log("Plus: " + e.toString());
        } finally {
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
