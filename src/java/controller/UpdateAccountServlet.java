
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

public class UpdateAccountServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("updateAccount.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int accountID = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String gender_raw = request.getParameter("gender");
        boolean gender = false;
        if("male".equalsIgnoreCase(gender_raw)){
            gender = true;
        }
        String password = request.getParameter("password");
        
        new AccountDAO().updateAccount(name, address, phone, dob, gender, password, accountID);
        Account acc = (Account) request.getSession().getAttribute("acc");
        acc.setAddress(address);
        acc.setName(name);
        acc.setDob(dob);
        acc.setPassword(password);
        acc.setPhone(phone);
        acc.setGender(gender);
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.println("<script type=\"text/javascript\">");
        pw.println("alert('Update information successfully');");
        pw.println("</script>");
        request.getRequestDispatcher("index.jsp").include(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
