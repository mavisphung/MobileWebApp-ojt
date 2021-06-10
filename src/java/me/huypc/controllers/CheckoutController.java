/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import me.huypc.dao.OrderRepository;
import me.huypc.dbutil.DbConnection;
import me.huypc.dbutil.SD;
import me.huypc.dto.OrderDetail;
import me.huypc.dto.OrderHeader;
import me.huypc.dto.Product;
import me.huypc.dto.User;

/**
 *
 * @author Admin
 */
public class CheckoutController extends HttpServlet {

    private final String SUCCESS = "success.jsp";
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
        Connection con = DbConnection.getConnection();
        String strTotal = request.getParameter("total");
        OrderRepository orderRepo = new OrderRepository(con);
        HttpSession session = request.getSession();
        try {
            double total = Double.parseDouble(strTotal);
            User user = (User) session.getAttribute(SD.LOGIN_USER);
//            List<Product> productList = (List<Product>) session.getAttribute(SD.USER_CARTS);
            
            //Xử lí đơn mã đơn
            OrderHeader header = new OrderHeader(user.getId());
            header.setOrderDate(new Date());
            header.setStatus(SD.STATUS_PENDING);
            header.setTotal(total);
            
            orderRepo.add(header);
            
            header = orderRepo.get(user.getId(), new Date(), SD.STATUS_PENDING);
            session.setAttribute(SD.ORDER_HEADER, header);
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
