/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ComboDAO;
import dao.ComboProductDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Combo;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class AddComboServlet extends HttpServlet {

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
            out.println("<title>Servlet AddComboServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddComboServlet at " + request.getContextPath() + "</h1>");
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
        List<Combo> combos = new ComboDAO().getAllCombos();
        request.setAttribute("combos", combos);
        request.setAttribute("ok", 1);
        request.getRequestDispatcher("staff-combo.jsp").forward(request, response);
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
        int mainID = Integer.parseInt(request.getParameter("main"));
        int sideID = Integer.parseInt(request.getParameter("side"));
        int bevarageID = Integer.parseInt(request.getParameter("bevarage"));
        int m_quantity = Integer.parseInt(request.getParameter("m_quantity"));
        int s_quantity = Integer.parseInt(request.getParameter("s_quantity"));
        int b_quantity = Integer.parseInt(request.getParameter("b_quantity"));
        String comboName = request.getParameter("comboName");
        int exPoint = Integer.parseInt(request.getParameter("exPoint"));
        int accPoint = Integer.parseInt(request.getParameter("accPoint"));
        float discount = Float.parseFloat(request.getParameter("discount"));
        
        Product mainProduct = new ProductDAO().getProductByID(mainID);
        Product sideProduct = new ProductDAO().getProductByID(sideID);
        Product bevarage = new ProductDAO().getProductByID(bevarageID);
        int totalCalories = mainProduct.getCalories() * m_quantity + sideProduct.getCalories() * s_quantity + bevarage.getCalories() * b_quantity;
        float totalPrice = (mainProduct.getPrice() * m_quantity + sideProduct.getPrice() * s_quantity + bevarage.getPrice() * b_quantity) * (1 - discount);
        
        int comboID = new ComboDAO().addNewComboReturnKey(comboName,totalCalories,totalPrice,exPoint,accPoint);
        new ComboProductDAO().addNewComboDetail(comboID, mainID, m_quantity);
        new ComboProductDAO().addNewComboDetail(comboID, sideID, s_quantity);
        new ComboProductDAO().addNewComboDetail(comboID, bevarageID, b_quantity);
        
        List<Combo> combos = new ComboDAO().getAllCombos();
        request.setAttribute("combos", combos);
        request.getRequestDispatcher("staff-combo.jsp").forward(request, response);
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
