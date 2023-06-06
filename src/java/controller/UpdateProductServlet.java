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
public class UpdateProductServlet extends HttpServlet {

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
            out.println("<title>Servlet UpdateProductServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateProductServlet at " + request.getContextPath() + "</h1>");
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
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = new ProductDAO().getProductByID(id);
        System.out.println(product);
        request.setAttribute("product", product);
        request.setAttribute("list", list);
        request.setAttribute("cList", cList);
        request.setAttribute("okela", 1);
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
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String image = request.getParameter("image");
        int categoryID = Integer.parseInt(request.getParameter("categoryID"));
        int calories = Integer.parseInt(request.getParameter("calories"));
        int accPoint = Integer.parseInt(request.getParameter("accPoint"));
        int exPoint = Integer.parseInt(request.getParameter("exPoint"));
        int productID = Integer.parseInt(request.getParameter("productID"));
        String s_date = request.getParameter("s_date");
        int price = Integer.parseInt(request.getParameter("price"));
        int original_price = Integer.parseInt(request.getParameter("original_price"));
        new ProductDAO().updateProduct(productID,name,quantity,image,categoryID,calories,accPoint,exPoint);
        
        if(price != original_price){
            int priceID = new PriceDAO().getPriceID(productID, s_date);
            new PriceDAO().updatePriceByPriceID(priceID);
            new PriceDAO().createNewPrice(productID, price);
        }
        
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
