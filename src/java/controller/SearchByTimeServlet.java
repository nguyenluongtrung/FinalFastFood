/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Order;

/**
 *
 * @author ADMIN
 */
public class SearchByTimeServlet extends HttpServlet {

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
            out.println("<title>Servlet SearchByTimeServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchByTimeServlet at " + request.getContextPath() + "</h1>");
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
        List<Order> list = new ArrayList<>();
        int year = -1, month = -1, date = -1;

        if (request.getParameter("year") != "") {
            year = Integer.parseInt(request.getParameter("year"));
        }

        if (request.getParameter("month") != "") {
            month = Integer.parseInt(request.getParameter("month"));
        }

        if (request.getParameter("date") != "") {
            date = Integer.parseInt(request.getParameter("date"));
        }
        
        int listSize = 0;
        
        if (request.getParameter("index") == null) {
            if (year != -1 && month != -1 && date != -1) {
                // search by year, month, date
                list = new OrderDAO().searchOrderByTime(1, year, month, date, 1);
                listSize = new OrderDAO().searchOrderByTime(1, year, month, date).size();
            } else if (year != -1 && month != -1) {
                // search by year, month
                list = new OrderDAO().searchOrderByTime(2, year, month, -1, 1);
                listSize = new OrderDAO().searchOrderByTime(2, year, month, -1).size();
            } else if (year != -1 && date != -1) {
                // search by year, date
                list = new OrderDAO().searchOrderByTime(3, year, -1, date, 1);
                listSize = new OrderDAO().searchOrderByTime(3, year, -1, date).size();
            } else if (year != -1) {
                // search by year
                list = new OrderDAO().searchOrderByTime(4, year, -1, -1, 1);
                listSize = new OrderDAO().searchOrderByTime(4, year, -1, -1).size();
            } else if (month != -1 && date != -1) {
                // search by month, date
                list = new OrderDAO().searchOrderByTime(5, -1, month, date, 1);
                listSize = new OrderDAO().searchOrderByTime(5, -1, month, date).size();
            } else if (month != -1) {
                // search by month
                list = new OrderDAO().searchOrderByTime(6, -1, month, -1, 1);
                listSize = new OrderDAO().searchOrderByTime(6, -1, month, -1).size();
            } else if (date != -1) {
                // search by date
                list = new OrderDAO().searchOrderByTime(7, -1, -1, date, 1);
                listSize = new OrderDAO().searchOrderByTime(7, -1, -1, date).size();
            }
        }
        else{
            int index = Integer.parseInt(request.getParameter("index"));
            if (year != -1 && month != -1 && date != -1) {
                // search by year, month, date
                list = new OrderDAO().searchOrderByTime(1, year, month, date, index);
                listSize = new OrderDAO().searchOrderByTime(1, year, month, date).size();
            } else if (year != -1 && month != -1) {
                // search by year, month
                list = new OrderDAO().searchOrderByTime(2, year, month, -1, index);
                listSize = new OrderDAO().searchOrderByTime(2, year, month, -1).size();
            } else if (year != -1 && date != -1) {
                // search by year, date
                list = new OrderDAO().searchOrderByTime(3, year, -1, date, index);
                listSize = new OrderDAO().searchOrderByTime(3, year, -1, date).size();
            } else if (year != -1) {
                // search by year
                list = new OrderDAO().searchOrderByTime(4, year, -1, -1, index);
                listSize = new OrderDAO().searchOrderByTime(4, year, -1, -1).size();
            } else if (month != -1 && date != -1) {
                // search by month, date
                list = new OrderDAO().searchOrderByTime(5, -1, month, date, index);
                listSize = new OrderDAO().searchOrderByTime(5, -1, month, date).size();
            } else if (month != -1) {
                // search by month
                list = new OrderDAO().searchOrderByTime(6, -1, month, -1, index);
                listSize = new OrderDAO().searchOrderByTime(6, -1, month, -1).size();
            } else if (date != -1) {
                // search by date
                list = new OrderDAO().searchOrderByTime(7, -1, -1, date, index);
                listSize = new OrderDAO().searchOrderByTime(7, -1, -1, date).size();
            }
        }

        // number of page
        int numberPage = 0;
        if (listSize % 20 == 0) {
            numberPage = listSize / 20;
        } else {
            numberPage = listSize / 20 + 1;
        }

        if (request.getParameter("year") != "") {
            year = Integer.parseInt(request.getParameter("year"));
            request.setAttribute("year", year);
        }

        if (request.getParameter("month") != "") {
            month = Integer.parseInt(request.getParameter("month"));
            request.setAttribute("month", month);
        }

        if (request.getParameter("date") != "") {
            date = Integer.parseInt(request.getParameter("date"));
            request.setAttribute("date", date);
        }
        request.setAttribute("search", 1);
        request.setAttribute("numberPage", numberPage);
        request.setAttribute("list", list);
        request.setAttribute("listSize", listSize);
        request.getRequestDispatcher("admin-order.jsp").forward(request, response);

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
