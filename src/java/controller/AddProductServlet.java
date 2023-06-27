/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CategoryDAO;
import dao.PriceDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class AddProductServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddProductServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddProductServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        List<Category> cList = new CategoryDAO().getAllCategory();
        List<Product> list = new ProductDAO().getAllProducts();
        Product surpriseProduct = new ProductDAO().getSurpriseProduct();
        if(surpriseProduct == null){
            request.setAttribute("surpriseProduct", 1);
        }
        request.setAttribute("list", list);
        request.setAttribute("cList", cList);
        request.setAttribute("ok", 1);
        request.getRequestDispatcher("admin-product.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String image = request.getParameter("image");
        int categoryID = Integer.parseInt(request.getParameter("categoryID"));
        int calories = Integer.parseInt(request.getParameter("calories"));
        int accPoint = Integer.parseInt(request.getParameter("accPoint"));
        int exPoint = Integer.parseInt(request.getParameter("exPoint"));

        float price = Float.parseFloat(request.getParameter("price"));

        int productID = 0;
        if ((request.getParameter("p_startDate") != null) && (request.getParameter("p_endDate") != null)) {
            String p_startDate = request.getParameter("p_startDate");
            String p_endDate = request.getParameter("p_endDate");
            productID = new ProductDAO().createProductReturnKey(name, image, categoryID, calories, accPoint, exPoint, p_startDate, p_endDate);
        } else {
            productID = new ProductDAO().createProductReturnKey(name, image, categoryID, calories, accPoint, exPoint);
        }
        new PriceDAO().createNewPrice(productID, price);

        List<Product> list = new ProductDAO().getAllProducts();
        request.setAttribute("list", list);
        request.getRequestDispatcher("admin-product.jsp").forward(request, response);
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
