package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 * Servlet implementation class NewPassword
 */
@WebServlet("/newPassword")
public class NewPasswordServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String password1 = request.getParameter("password");
        String password2 = request.getParameter("confPassword");
        Account account = new AccountDAO().getAccountByEmail(email);
        if (account != null) {
            if (password1.equals(password2)) { // cap nhat password
                new AccountDAO().updatePassword(password2, account);
                request.setAttribute("ok", 1);
                request.setAttribute("ms1", "SUCCESS !");
                request.setAttribute("ms2", "You Have Successfully Created New Password");
            } else { // confirmed password bi sai
                request.setAttribute("ok", 0);
                request.setAttribute("ms1", "FAIL !");
                request.setAttribute("ms2", "Your confirmed password was wrong");
            }
        } else { // email ko ton tai
            request.setAttribute("ok", 0);
            request.setAttribute("ms1", "FAIL !");
            request.setAttribute("ms2", "Your email is not valid");
        }
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

}
