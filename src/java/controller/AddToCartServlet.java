/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import dao.SaleDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Cart;
import model.Item;
import model.Product;
import model.Sale;

/**
 *
 * @author ADMIN
 */
public class AddToCartServlet extends HttpServlet {

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
            out.println("<title>Servlet AddToCartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddToCartServlet at " + request.getContextPath() + "</h1>");
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
        try {
            HttpSession session = request.getSession();
            Cart cart = null;
            if ((Cart) session.getAttribute("cart") == null) {
                cart = new Cart();
            } else {
                cart = (Cart) session.getAttribute("cart");
            }

            String productID_raw = request.getParameter("productID");

            if (productID_raw != null) {
                int productID = Integer.parseInt(productID_raw);
                Product product = new ProductDAO().getProductByID(productID);
                int quantity = 0;
                if (request.getParameter("quantity") != null) {
                    quantity = Integer.parseInt(request.getParameter("quantity"));
                } else {
                    quantity = 1;
                }
                Item item = new Item(product, quantity);
                cart.addItemToCart(item);
                request.setAttribute("productID", productID);
            }

            session.setAttribute("cart", cart);
            session.setAttribute("subtotal", cart.getTotalMoney());
            session.setAttribute("count", cart.getItems().size());
            session.setMaxInactiveInterval(-1);
            List<Item> items = cart.getItems();
            request.setAttribute("items", items);
            
            request.getRequestDispatcher("cart.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        String code = request.getParameter("code");
        Sale sale = new SaleDAO().getSaleByDate();
        if (code.equalsIgnoreCase(sale.getSaleCode())) {
            try {
                HttpSession session = request.getSession();
                Cart cart = null;
                if ((Cart) session.getAttribute("cart") == null) {
                    cart = new Cart();
                } else {
                    cart = (Cart) session.getAttribute("cart");
                }      
                session.setAttribute("cart", cart);
                session.setAttribute("count", cart.getItems().size());
                session.setAttribute("subtotal", cart.getTotalMoney()*(1 - sale.getSaleValue()));
                session.setMaxInactiveInterval(-1);
                List<Item> items = cart.getItems();
                request.setAttribute("items", items);
                
            } catch (ParseException ex) {
                Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                HttpSession session = request.getSession();
                Cart cart = null;
                if ((Cart) session.getAttribute("cart") == null) {
                    cart = new Cart();
                } else {
                    cart = (Cart) session.getAttribute("cart");
                }
                request.setAttribute("ms", "Sale code is invalid!");
                session.setAttribute("cart", cart);
                session.setAttribute("count", cart.getItems().size());
                session.setAttribute("subtotal", cart.getTotalMoney());
                session.setMaxInactiveInterval(-1);
                List<Item> items = cart.getItems();
                request.setAttribute("items", items);
            } catch (ParseException ex) {
                Logger.getLogger(AddToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        request.getRequestDispatcher("cart.jsp").forward(request, response);
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
