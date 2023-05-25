/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import dao.AccountDAO;

/**
 *
 * @author Admin
 */
public class UpdateAccountConfirmServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Account user = (Account) request.getSession().getAttribute("acc");
        String accRole, accCreatedDate, accName, accAddress, accPhone, accEmail, accDob, accPassword, accPassword2;
        int totalAccumulatedPoint;
        boolean gender;

        accName = request.getParameter("name");
        accAddress = request.getParameter("address");
        accPhone = request.getParameter("phone");
        accDob = request.getParameter("dob");
        gender = Boolean.getBoolean(request.getParameter("gender"));
        accPassword = request.getParameter("password");
        accPassword2 = request.getParameter("password2");

        Account updateAccount = new Account(user.getAccountID(), user.getRole(), user.getCreatedDate(), accName, accAddress, accPhone, user.getEmail(), accDob, gender, user.getTotalAccumulatedPoint(), accPassword);
        AccountDAO dao = new AccountDAO();
        if (dao.updateAccount(updateAccount)) {
            request.setAttribute("msg", "Update successfully!");
        } else {
            request.setAttribute("msg", "Update Failse!");
        }
        request.setAttribute("user", user);
        request.getRequestDispatcher("updateAccount.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
