 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class AddproductServlet extends HttpServlet {

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
        String nameproduct = request.getParameter("nameproduct");
        String image = request.getParameter("image");
        String cate= request.getParameter("category");
        int category=Integer.parseInt(cate);
        String quan= request.getParameter("quantity");
        int quantity=Integer.parseInt(quan);
        String calo= request.getParameter("calories");
        int calories=Integer.parseInt(calo);
        String surpri= request.getParameter("issurprise");
        boolean issurprise=Boolean.getBoolean(surpri);
        String ra="0.0";
        float rating =Float.parseFloat(ra);
        String accum= request.getParameter("accumlated");
        int accumlated=Integer.parseInt(accum);
        String exchange= request.getParameter("exchanged");
        int exchangepoint=Integer.parseInt(exchange);
        
        
        new ProductDAO().createProduct(new Product(nameproduct, image, category, quantity, calories, issurprise, rating, accumlated, exchangepoint));

 
        request.getRequestDispatcher("crud-product.jsp").include(request, response);
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
