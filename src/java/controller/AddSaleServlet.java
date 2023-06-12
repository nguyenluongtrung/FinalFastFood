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
import model.Sale;
import model.StatisticalProduct;

/**
 *
 * @author ADMIN
 */
public class AddSaleServlet extends HttpServlet {

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
            out.println("<title>Servlet AddSaleServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddSaleServlet at " + request.getContextPath() + "</h1>");
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
        List<Sale> sList = new SaleDAO().getAllSales();
        List<StatisticalProduct> wList =  new ProductDAO().getSpecialProducts(0);
        String wItems = "";
        int i = 0;
        for(StatisticalProduct item : wList){
            ++i;
            if(i != wList.size()){
                wItems += item.getName() + ", ";
            }
            else{
                wItems += item.getName();
            }
        }
        request.setAttribute("ok", 1);
        request.setAttribute("sList", sList);
        request.setAttribute("wList", new ProductDAO().getSpecialProducts(0));
        request.setAttribute("wItems", wItems);
        request.getRequestDispatcher("admin-sale.jsp").forward(request, response);
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
        String name = request.getParameter("s-name");
        float value = Float.parseFloat(request.getParameter("s-value"));
        String code = request.getParameter("s-code");
        String s_date = request.getParameter("s-start");
        String e_date = request.getParameter("s-end");
        int quantity = Integer.parseInt(request.getParameter("s-quantity"));
        
        int saleID = new SaleDAO().addNewSaleReturnKey(name, value, code, s_date, e_date);
        
        List<StatisticalProduct> wList =  new ProductDAO().getSpecialProducts(0);
        for(StatisticalProduct item : wList){
            new SaleProductDAO().createNewSaleDetail(item.getProductID(), saleID, quantity);
        }
        
        List<Sale> sList = new SaleDAO().getAllSales();
        request.setAttribute("sList", sList);
        request.getRequestDispatcher("admin-sale.jsp").forward(request, response);
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
