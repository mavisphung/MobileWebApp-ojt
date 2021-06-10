/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import me.huypc.dao.ProductRepository;
import me.huypc.dao.UserRepository;
import me.huypc.dbutil.DbConnection;
import me.huypc.dbutil.SD;
import me.huypc.dto.Product;
import me.huypc.dto.User;

/**
 *
 * @author Admin
 */
public class LoginController extends HttpServlet {

    private final String ADMIN = "add-product.jsp";
    private final String ERROR = "index.html";
    private final String MEMBER = "products-list.jsp";

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
        String url = ERROR;
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");

        try {
            Connection con = DbConnection.getConnection();
            String sqlString = "SELECT * FROM Users "
                                + "WHERE username = ? AND password = ?";
            PreparedStatement pstm = con.prepareStatement(sqlString);
            pstm.setString(1, username);
            pstm.setString(2, password);
            
            UserRepository repo = new UserRepository(con);
            repo.setStatement(pstm);
            User loggedInUser = repo.getLoggedInUser(username, password);
            
            if (loggedInUser != null) {
                if (loggedInUser.getRoleId() == SD.ROLE_ADMIN) { //1 admin, 2 member
                    url = ADMIN;
                } else {
                    //lấy product từ db
                    ProductRepository pRepo = new ProductRepository(con);
                    String sql = "SELECT * FROM Products";
                    pstm = con.prepareStatement(sql);
                    pRepo.setStatement(pstm);
                    List<Product> products = pRepo.getAll();
                    HttpSession session = request.getSession();
                    session.setAttribute(SD.PRODUCT_LIST, products);
                    url = MEMBER;
                }
                HttpSession session = request.getSession();
                session.setAttribute(SD.LOGIN_USER, loggedInUser);
            }
            repo.close();
        } catch (Exception e) {
            log("Error at LoginController: " + e.toString());
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
