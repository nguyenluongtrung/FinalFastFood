/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import dao.SaleDAO;
import dao.SaleProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.Sale;
import model.SaleProduct;
import model.StatisticalProduct;

/**
 *
 * @author ADMIN
 */
public class HomeControlServlet extends HttpServlet {

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
            out.println("<title>Servlet HomeControlServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeControlServlet at " + request.getContextPath() + "</h1>");
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

        Sale sale = new SaleDAO().getSaleByDate();
        Product surpriseProduct = new ProductDAO().getSurpriseProduct();
        if (sale != null && surpriseProduct == null) {
            List<SaleProduct> saleList = new SaleProductDAO().getAllCurrentSaleProducts();
            String wItems = "";
            int i = 0;
            for (SaleProduct item : saleList) {
                ++i;
                if (item.getSaleQuantity() > 0) {
                    if (i != saleList.size()) {
                        wItems += item.getProductName() + ", ";
                    } else {
                        wItems += item.getProductName();
                    }
                } else {
                    if (i == saleList.size()) {
                        wItems = wItems.substring(0, wItems.length() - 2);
                    }
                }
            }
            float saleValue = (float) Math.round(sale.getSaleValue() * 100) / 100 * 100;

            request.setAttribute("wItems", wItems);
            request.setAttribute("saleValue", saleValue);
            request.setAttribute("sale", new SaleDAO().getSaleByDate());
            request.setAttribute("ok", 1);
        } else if (sale == null && surpriseProduct != null) {
            request.setAttribute("surpriseProduct", surpriseProduct);
            request.setAttribute("okela", 1);
        } else if(sale != null && surpriseProduct != null) {
            List<SaleProduct> saleList = new SaleProductDAO().getAllCurrentSaleProducts();
            String wItems = "";
            int i = 0;
            for (SaleProduct item : saleList) {
                ++i;
                if (item.getSaleQuantity() > 0) {
                    if (i != saleList.size()) {
                        wItems += item.getProductName() + ", ";
                    } else {
                        wItems += item.getProductName();
                    }
                } else {
                    if (i == saleList.size()) {
                        wItems = wItems.substring(0, wItems.length() - 2);
                    }
                }
            }
            float saleValue = (float) Math.round(sale.getSaleValue() * 100) / 100 * 100;

            request.setAttribute("wItems", wItems);
            request.setAttribute("saleValue", saleValue);
            request.setAttribute("sale", new SaleDAO().getSaleByDate());
            request.setAttribute("surpriseProduct", surpriseProduct);
            request.setAttribute("okelala", 1);
        }
        request.setAttribute("someProducts", new ProductDAO().getSomeProducts());
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
