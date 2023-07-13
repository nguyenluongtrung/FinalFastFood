/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.ComboDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Combo;
import model.Product;

/**
 *
 * @author ASUS
 */
public class SearchByPriceServlet extends HttpServlet {

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
            out.println("<title>Servlet SearchByPrice</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchByPrice at " + request.getContextPath() + "</h1>");
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
        float from = Float.parseFloat(request.getParameter("from"));
        float to = Float.parseFloat(request.getParameter("to"));
        List<Product> listProduct = new ArrayList<>();
        List<Combo> listCombo = new ArrayList<>();
        if (request.getParameter("index") == null) {
            listProduct = new ProductDAO().searchProductByPrice(from, to, 1);
            listCombo = new ComboDAO().searchComboByPrice(from, to, 1);
        } else {
            int index = Integer.parseInt(request.getParameter("index"));
            listProduct = new ProductDAO().searchProductByPrice(from, to, index);
            listCombo = new ComboDAO().searchComboByPrice(from, to, index);
        }

        if (listProduct.size() == 0 && listCombo.size() == 0) {
            request.setAttribute("pageNumber", 1);
            request.setAttribute("ms", "Your searched products not found!");
        } else if (listProduct.size() > 0 && listCombo.size() > 0) {
            int pageNumber = new ProductDAO().getPageNumberSearchProductByPrice(from, to) + new ComboDAO().getPageNumberSearchComboByPrice(from, to);
            request.setAttribute("pageNumber", pageNumber);
            request.setAttribute("list", listProduct);
            request.setAttribute("listCombo", listCombo);
            request.setAttribute("isCombo", 1);
        } else if (listProduct.size() > 0) {
            int pageNumber = new ProductDAO().getPageNumberSearchProductByPrice(from, to);
            request.setAttribute("pageNumber", pageNumber);
            request.setAttribute("list", listProduct);
        } else if (listCombo.size() > 0) {
            int pageNumber = new ComboDAO().getPageNumberSearchComboByPrice(from, to);
            request.setAttribute("pageNumber", pageNumber);
            request.setAttribute("listCombo", listCombo);
            request.setAttribute("isCombo", 1);
        }

        request.setAttribute("to", to);
        request.setAttribute("from", from);
        request.setAttribute("price", 1);
        request.getRequestDispatcher("shop.jsp").forward(request, response);
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
