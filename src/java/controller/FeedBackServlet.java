/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.FeedbackDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.FeedBack;
import model.Product;

/**
 *
 * @author PC
 */
public class FeedBackServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FeedBackServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FeedBackServlet at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        
         // request.getRequestDispatcher("single-product.jsp").forward(request, response);

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
        //processRequest(request, response);
        HttpSession session = request.getSession();
        int pid = Integer.parseInt(request.getParameter("pid"));
        int count = new FeedbackDAO().countFeedBack(pid);
        //
        
        //tính rating
//       (tổng rate cũ + rate mới) / (tổng người cũ + 1)

        float orate = Float.parseFloat(request.getParameter("orate"));
        int nrate = 0;
        try {
            nrate = Integer.parseInt(request.getParameter("rate"));
            //(2*1+3)/(1+1)=2.5
            float rating = 1.0f * ((orate * count + nrate) / (count + 1));
            ProductDAO product = new ProductDAO();
            product.updateRating(rating, pid);
            // add feedback
            Account account = (Account) session.getAttribute("acc");
            int accountID = account.getAccountID();
            String msg = request.getParameter("feedback");
            FeedBack feedback = new FeedBack(0, msg, "", "", accountID, pid);
//        request.setAttribute("feed", feedback);
            new FeedbackDAO().addNewFeedback(feedback);
            response.sendRedirect("single-product?id=" + pid);
        } catch (IOException | NumberFormatException e) {
            response.setContentType("text/html");
            PrintWriter pw = response.getWriter();
            pw.println("<script type=\"text/javascript\">");
            pw.println("alert('Please vote before giving feedback');");
            pw.println("</script>");
            response.sendRedirect("single-product?id=" + pid);
        }


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
