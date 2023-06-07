
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.AccountDAO;
import dao.FeedbackDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import dao.ProductOrderDetailDAO;
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
import model.FeedbackAccount;
import model.Order;
import model.Product;
import model.ProductOrderDetail;

public class UpdateAccountServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        int accountID = acc.getAccountID();
        List<Order> orders = new OrderDAO().getOrderByAccountID(accountID);
        List<FeedBack> feeds = new FeedbackDAO().getFeedbacksByAccountID(accountID);
        List<Product> products = new ProductDAO().getAllProducts();
        request.setAttribute("products", products);
        request.setAttribute("orders", orders);
        request.setAttribute("feeds", feeds);
        request.getRequestDispatcher("updateAccount.jsp").forward(request, response);
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
        if ("male".equalsIgnoreCase(gender_raw)) {
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
