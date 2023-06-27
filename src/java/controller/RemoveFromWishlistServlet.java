/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Combo;
import model.ComboWishList;
import model.Product;
import model.WishList;

public class RemoveFromWishlistServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RemoveFromCartServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RemoveFromCartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        WishList wlist = null;
        if ((WishList) session.getAttribute("wlist") == null) {
            wlist = new WishList();
        } else {
            wlist = (WishList) session.getAttribute("wlist");
        }
        ComboWishList cwlist = null;
        if((ComboWishList) session.getAttribute("cwlist") == null){
            cwlist = new ComboWishList();
        }
        else{
            cwlist = (ComboWishList) session.getAttribute("cwlist");
        }
        if(request.getParameter("productID") != null){
            int productID = Integer.parseInt(request.getParameter("productID"));
            wlist.removeProduct(productID);
            session.setAttribute("wlist", wlist);
        }
        
        if(request.getParameter("comboID") != null){
            int comboID = Integer.parseInt(request.getParameter("comboID"));
            cwlist.removeProduct(comboID);
            session.setAttribute("cwlist", cwlist);
        }

        session.setMaxInactiveInterval(-1);
        List<Product> products = wlist.getProducts();
        request.setAttribute("products", products);
        List<Combo> combos = cwlist.getCombos();
        request.setAttribute("combos", combos);
        request.getRequestDispatcher("wishList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
