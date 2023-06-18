/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ComboDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Combo;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class SearchProductByCategoryIDServlet extends HttpServlet {

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
            out.println("<title>Servlet SearchProductByCategoryIDServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SearchProductByCategoryIDServlet at " + request.getContextPath() + "</h1>");
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
        int id = Integer.parseInt(request.getParameter("id"));
        int ok = Integer.parseInt(request.getParameter("ok"));
        HttpSession session = request.getSession();     
        if(ok == 1){
            List<Product> mainCourse = new ProductDAO().getProductsByCategoryID(id);
            
            session.setAttribute("mainCourse", mainCourse);
            if(session.getAttribute("sideDish") != null){
                List<Product> sideDish = (List<Product>) session.getAttribute("sideDish");
                request.setAttribute("sideDish", sideDish);
            }
            if(session.getAttribute("bevarage") != null){
                List<Product> bevarage = (List<Product>) session.getAttribute("bevarage");
                request.setAttribute("bevarage", bevarage);
            }
            request.setAttribute("mainCourse", mainCourse);
        }
        else if(ok == 2){
            List<Product> sideDish = new ProductDAO().getProductsByCategoryID(id);
            session.setAttribute("sideDish", sideDish);
            if(session.getAttribute("mainCourse") != null){
                List<Product> mainCourse = (List<Product>) session.getAttribute("mainCourse");
                request.setAttribute("mainCourse", mainCourse);
            }
            if(session.getAttribute("bevarage") != null){
                List<Product> bevarage = (List<Product>) session.getAttribute("bevarage");
                request.setAttribute("bevarage", bevarage);
            }
            
            request.setAttribute("sideDish", sideDish);
        }
        else if(ok == 3){
            List<Product> bevarage = new ProductDAO().getProductsByCategoryID(id);
            session.setAttribute("bevarage", bevarage);
            if(session.getAttribute("mainCourse") != null){
                List<Product> mainCourse = (List<Product>) session.getAttribute("mainCourse");
                request.setAttribute("mainCourse", mainCourse);
            }
            if(session.getAttribute("sideDish") != null){
                List<Product> sideDish = (List<Product>) session.getAttribute("sideDish");
                request.setAttribute("sideDish", sideDish);
            }
            
            request.setAttribute("bevarage", bevarage);
        }
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
