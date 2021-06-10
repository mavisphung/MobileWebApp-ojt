/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.huypc.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import me.huypc.dao.ProductRepository;
import me.huypc.dbutil.DbConnection;
import me.huypc.dbutil.SD;
import me.huypc.dto.Product;

/**
 *
 * @author Admin
 */
@MultipartConfig
public class ProductController extends HttpServlet {

//    private final String SUCCESS = "products-list.jsp";
    private final String ADD_PRODUCT = "add-product.jsp";

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
        String name = request.getParameter("name");
        String strUnitPrice = request.getParameter("unitPrice");
        String strAvailable = request.getParameter("available");
        String description = request.getParameter("description");
        String manufacturer = request.getParameter("manufacturer");
        String category = request.getParameter("category");
        String condition = request.getParameter("flexRadioDefault");
        String imageUrl = "";
        Part part = null;
        try {
            //Lưu ảnh vào đường dẫn /images/products
            part = request.getPart("image");
            String path = "/images/products/" + part.getSubmittedFileName();
            String filename = request.getServletContext().getRealPath(path);

            part.write(filename);
            imageUrl = SD.convertToImgSrc(filename);
//            System.out.println(part.getContentType());
//            System.out.println(request.getServletPath()); //in ra /ProductController
            System.out.println(filename);
            System.out.println(imageUrl);
            //kiểm tra đuôi ảnh
            if (!filename.endsWith("jpg")
                    && !path.endsWith("png")) {
                url = ADD_PRODUCT;
                request.setAttribute(SD.NOT_IMAGE_FILE, "You must choose an image with extensions jpg, png");
                return;
            }

            //parse
            double unitPrice = Double.parseDouble(strUnitPrice);
            int unitsInStocks = Integer.parseInt(strAvailable);

            //Lưu products vào database
            Product newObj = new Product(name, imageUrl, manufacturer, category, condition, unitsInStocks, description, unitPrice);
            Connection con = DbConnection.getConnection();
            ProductRepository repo = new ProductRepository(con);
            repo.add(newObj);
            repo.close();

            url = ADD_PRODUCT;
            request.setAttribute(SD.ADD_SUCCESS, "Add successfully!");
        } catch (Exception e) {
            log("Error at ProductController: " + e.toString());
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
