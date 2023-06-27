/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.CategoryRevenue;
import model.Product;
import model.StatisticalProduct;

/**
 *
 * @author ADMIN
 */
public class AdminPageServlet extends HttpServlet {

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
            out.println("<title>Servlet AdminPageServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminPageServlet at " + request.getContextPath() + "</h1>");
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
        List<StatisticalProduct> hList = new ProductDAO().getSpecialProducts(1);

        List<StatisticalProduct> wList = new ProductDAO().getSpecialProducts(0);

        List<CategoryRevenue> cList = new ProductDAO().getAllCategoryRevenue();
        float[] crList = new float[10];
        for (int i = 1; i <= 10; i++) {
            int ok = 0;
            for (CategoryRevenue c : cList) {
                if (i == c.getCategoryID()) {
                    crList[i - 1] = c.getTotalPrice();
                    ok = 1;
                    break;
                }
            }
            if (ok == 0) {
                crList[i - 1] = 0;
            }
        }

        Product surpriseProduct = new ProductDAO().getSurpriseProduct();

        if (surpriseProduct != null) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date p_endDate = sdf.parse(surpriseProduct.getP_endDate());
                Date cDate = new Date();

                int result = cDate.compareTo(p_endDate);
                if (result > 0) {
                    new ProductDAO().updateProductStatus(surpriseProduct.getProductID(), false);
                }
            } catch (ParseException ex) {
                Logger.getLogger(ManageProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        request.setAttribute("crList", Arrays.toString(crList));
        request.setAttribute("hList", hList);
        request.setAttribute("wList", wList);
        request.getRequestDispatcher("admin-dashboard.jsp").forward(request, response);
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
