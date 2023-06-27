/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ComboDAO;
import dao.FeedbackDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.ProductOrderDetailDAO;
import dao.SaleDAO;
import dao.SaleProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.ComboInfoOrderDetail;
import model.FeedBack;
import model.Order;
import model.Product;
import model.ProductOrderDetail;
import model.Sale;
import model.SaleProduct;

/**
 *
 * @author ADMIN
 */
public class ViewOrderDetailServlet extends HttpServlet {

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
            out.println("<title>Servlet ViewOrderDetailServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ViewOrderDetailServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        int accountID = acc.getAccountID();
        List<Product> products = new ProductDAO().getAllProducts();
        List<Order> orders = new OrderDAO().getOrderByAccountID(accountID);
        List<FeedBack> feeds = new FeedbackDAO().getFeedbacksByAccountID(accountID);
        int id = Integer.parseInt(request.getParameter("id"));
        List<ProductOrderDetail> orderDetails = new ProductOrderDetailDAO().getAllProductOrderDetailByOrderID(id);
        List<ComboInfoOrderDetail> comboOrderDetails = new ComboDAO().getAllComboOrderDetailByOrderID(id);
        Order order = new OrderDAO().getOrderByID(id);
        Sale sale = new SaleDAO().getSaleByOrderDate(order.getDate());
        System.out.println(sale);
        if(sale != null && order.isIsSale()){
            request.setAttribute("saleValue", sale.getSaleValue());
            List<SaleProduct> saleList = new SaleProductDAO().getAllSaleProductsBySaleID(sale.getSaleID());
            System.out.println(sale.getSaleValue());
            request.setAttribute("saleList", saleList);
            request.setAttribute("ok", 1);
        }
        request.setAttribute("products", products);
        request.setAttribute("orders", orders);
        request.setAttribute("feeds", feeds);
        request.setAttribute("orderDetails", orderDetails);
        request.setAttribute("comboOrderDetails", comboOrderDetails);
        request.getRequestDispatcher("view-order-details.jsp").forward(request, response);
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
