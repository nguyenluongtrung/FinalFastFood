/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import dao.ProductDAO;
import dao.SaleDAO;
import dao.SaleProductDAO;
import dao.ShippingDAO;
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
import model.Account;
import model.Cart;
import model.ComboCart;
import model.ComboItem;
import model.Item;
import model.Sale;
import model.SaleProduct;

/**
 *
 * @author ADMIN
 */
public class CheckoutServlet extends HttpServlet {

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
            out.println("<title>Servlet CheckoutServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutServlet at " + request.getContextPath() + "</h1>");
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
        HttpSession session = request.getSession();
        Account acc = (Account) session.getAttribute("acc");
        Cart cart = (Cart) session.getAttribute("cart");
        ComboCart comboCart = (ComboCart) session.getAttribute("comboCart");
        List<Item> items = cart.getItems();
        List<ComboItem> comboItems = comboCart.getComboItems();
        if (request.getParameter("okela") != null) {
            Sale sale = new SaleDAO().getSaleByDate();
            List<SaleProduct> saleList = new SaleProductDAO().getAllCurrentSaleProducts();
            request.setAttribute("saleValue", sale.getSaleValue());
            request.setAttribute("saleList", saleList);
            request.setAttribute("code", request.getParameter("code"));
            request.setAttribute("ok", 1);
        }
        if (request.getParameter("my_point") != null) {
            int my_point = Integer.parseInt(request.getParameter("my_point"));
            request.setAttribute("my_point", my_point);
        }

        if (request.getParameter("subtotal") != null) {
            float subtotal = Float.parseFloat(request.getParameter("subtotal"));
            session.setAttribute("subtotal", subtotal);
            request.setAttribute("subtotal", subtotal);
        }

        request.setAttribute("items", items);
        request.setAttribute("comboItems", comboItems);
        request.getRequestDispatcher("checkout.jsp").forward(request, response);
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
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String note = request.getParameter("note");

        HttpSession session = request.getSession();

        if (request.getParameter("type") != null) {
            String type = request.getParameter("type");
            if (type.equalsIgnoreCase("vnpay")) {
                session.setAttribute("vnpay_name", name);
                session.setAttribute("vnpay_email", email);
                session.setAttribute("vnpay_address", address);
                session.setAttribute("vnpay_phone", phone);
                session.setAttribute("vnpay_note", note);
                session.setAttribute("vnpay_code", request.getParameter("code"));
                session.setAttribute("vnpay_my_point", request.getParameter("my_point"));

                request.getRequestDispatcher("/vnpayajax").forward(request, response);
                return;
            }
        }

        int shippingID = new ShippingDAO().addShippingReturnKey(name, email, address, phone);

        Account acc = (Account) session.getAttribute("acc");

        Cart cart = null;
        if (session.getAttribute("cart") != null) {
            cart = (Cart) session.getAttribute("cart");
        }

        ComboCart comboCart = null;
        if (session.getAttribute("comboCart") != null) {
            comboCart = (ComboCart) session.getAttribute("comboCart");
        }

        int accountID = acc.getAccountID();

        List<SaleProduct> saleList = new SaleProductDAO().getAllCurrentSaleProducts();
        Sale sale = new SaleDAO().getSaleByDate();

        // check exist sale product in cart
        int isOke = 0;
        for (Item item : cart.getItems()) {
            for (SaleProduct saleProduct : saleList) {
                if (item.getProduct().getProductID() == saleProduct.getProductID()) {
                    isOke = 1;
                    break;
                }
            }
        }

        float totalPrice = (float) session.getAttribute("subtotal");
        int orderID = 0;
        if ((sale != null) && (request.getParameter("code") != "") && (isOke == 1)) {
            orderID = new OrderDAO().addOrderReturnKey(totalPrice, shippingID, note, accountID, true);
        } else {
            orderID = new OrderDAO().addOrderReturnKey(totalPrice, shippingID, note, accountID, false);
        }
        System.out.println("Code: " + request.getParameter("code"));

        List<Item> items = cart.getItems();
        for (Item i : items) {
            int productID = i.getProduct().getProductID();
            int quantity = i.getQuantity();
            new OrderDetailDAO().addOrderDetail(orderID, productID, quantity);
        }

        List<ComboItem> comboItems = comboCart.getComboItems();
        for (ComboItem i : comboItems) {
            int comboID = i.getCombo().getComboID();
            int quantity = i.getQuantity();
            new OrderDetailDAO().addComboOrderDetail(orderID, comboID, quantity);
        }

        if (request.getParameter("changeStatus") == null) {
            if ((sale != null) && (request.getParameter("code") != "")) {
                for (Item i : items) {
                    for (SaleProduct pro : saleList) {
                        if (i.getProduct().getProductID() == pro.getProductID()) {
                            if (i.getQuantity() > pro.getSaleQuantity()) {
                                int quantity = pro.getSaleQuantity();
                                new SaleProductDAO().updateQuantity(i.getProduct().getProductID(), quantity, sale.getSaleID());
                            } else {
                                int quantity = i.getQuantity();
                                new SaleProductDAO().updateQuantity(i.getProduct().getProductID(), quantity, sale.getSaleID());
                            }

                        }
                    }
                }
            }
        } else {
            if (Integer.parseInt(request.getParameter("changeStatus")) == 1) {
                if ((sale != null) && (request.getParameter("code") != "")) {
                    for (Item i : items) {
                        for (SaleProduct pro : saleList) {
                            if (i.getProduct().getProductID() == pro.getProductID()) {
                                if (i.getQuantity() > pro.getSaleQuantity()) {
                                    int quantity = pro.getSaleQuantity();
                                    new SaleProductDAO().updateQuantity(i.getProduct().getProductID(), quantity, sale.getSaleID());
                                } else {
                                    int quantity = i.getQuantity();
                                    new SaleProductDAO().updateQuantity(i.getProduct().getProductID(), quantity, sale.getSaleID());
                                }

                            }
                        }
                    }
                }
            }
        }

        if (request.getParameter("changeStatus") == null) {
            if ((request.getParameter("my_point") != "") && (request.getParameter("my_point") != null)) {
                int my_point = Integer.parseInt(request.getParameter("my_point"));
                new AccountDAO().updateAccumulatedPoints(acc.getAccountID(), my_point, 2);
                if (comboCart != null && cart != null) {
                    new AccountDAO().updateAccumulatedPoints(accountID, cart.getTotalAccumulatedPoints() + comboCart.getTotalAccumulatedPoints(), 1);
                    acc.setTotalAccumulatedPoint(my_point + cart.getTotalAccumulatedPoints() + comboCart.getTotalAccumulatedPoints());
                } else if (comboCart != null && cart == null) {
                    new AccountDAO().updateAccumulatedPoints(accountID, comboCart.getTotalAccumulatedPoints(), 1);
                    acc.setTotalAccumulatedPoint(my_point + comboCart.getTotalAccumulatedPoints());
                } else if (comboCart == null && cart != null) {
                    new AccountDAO().updateAccumulatedPoints(accountID, cart.getTotalAccumulatedPoints(), 1);
                    acc.setTotalAccumulatedPoint(my_point + cart.getTotalAccumulatedPoints());
                }
            } else {
                if (comboCart != null && cart != null) {
                    new AccountDAO().updateAccumulatedPoints(accountID, cart.getTotalAccumulatedPoints() + comboCart.getTotalAccumulatedPoints(), 1);
                    acc.setTotalAccumulatedPoint(acc.getTotalAccumulatedPoint() + cart.getTotalAccumulatedPoints() + comboCart.getTotalAccumulatedPoints());
                } else if (comboCart != null && cart == null) {
                    new AccountDAO().updateAccumulatedPoints(accountID, comboCart.getTotalAccumulatedPoints(), 1);
                    acc.setTotalAccumulatedPoint(acc.getTotalAccumulatedPoint() + comboCart.getTotalAccumulatedPoints());
                } else if (comboCart == null && cart != null) {
                    new AccountDAO().updateAccumulatedPoints(accountID, cart.getTotalAccumulatedPoints(), 1);
                    acc.setTotalAccumulatedPoint(acc.getTotalAccumulatedPoint() + cart.getTotalAccumulatedPoints());
                }
            }
        } else {
            if (Integer.parseInt(request.getParameter("changeStatus")) == 1) {
                if ((request.getParameter("my_point") != "") && (request.getParameter("my_point") != null)) {
                    int my_point = Integer.parseInt(request.getParameter("my_point"));
                    new AccountDAO().updateAccumulatedPoints(acc.getAccountID(), my_point, 2);
                    if (comboCart != null && cart != null) {
                        new AccountDAO().updateAccumulatedPoints(accountID, cart.getTotalAccumulatedPoints() + comboCart.getTotalAccumulatedPoints(), 1);
                        acc.setTotalAccumulatedPoint(my_point + cart.getTotalAccumulatedPoints() + comboCart.getTotalAccumulatedPoints());
                    } else if (comboCart != null && cart == null) {
                        new AccountDAO().updateAccumulatedPoints(accountID, comboCart.getTotalAccumulatedPoints(), 1);
                        acc.setTotalAccumulatedPoint(my_point + comboCart.getTotalAccumulatedPoints());
                    } else if (comboCart == null && cart != null) {
                        new AccountDAO().updateAccumulatedPoints(accountID, cart.getTotalAccumulatedPoints(), 1);
                        acc.setTotalAccumulatedPoint(my_point + cart.getTotalAccumulatedPoints());
                    }
                } else {
                    if (comboCart != null && cart != null) {
                        new AccountDAO().updateAccumulatedPoints(accountID, cart.getTotalAccumulatedPoints() + comboCart.getTotalAccumulatedPoints(), 1);
                        acc.setTotalAccumulatedPoint(acc.getTotalAccumulatedPoint() + cart.getTotalAccumulatedPoints() + comboCart.getTotalAccumulatedPoints());
                    } else if (comboCart != null && cart == null) {
                        new AccountDAO().updateAccumulatedPoints(accountID, comboCart.getTotalAccumulatedPoints(), 1);
                        acc.setTotalAccumulatedPoint(acc.getTotalAccumulatedPoint() + comboCart.getTotalAccumulatedPoints());
                    } else if (comboCart == null && cart != null) {
                        new AccountDAO().updateAccumulatedPoints(accountID, cart.getTotalAccumulatedPoints(), 1);
                        acc.setTotalAccumulatedPoint(acc.getTotalAccumulatedPoint() + cart.getTotalAccumulatedPoints());
                    }
                }
            }
        }

        if (request.getParameter("changeStatus") != null) {
            if (Integer.parseInt(request.getParameter("changeStatus")) == 1) {
                new OrderDAO().updateOrderStatus(orderID, "SUCC");
            } else {
                new OrderDAO().updateOrderStatus(orderID, "FAIL");
            }
        }

        session.removeAttribute("cart");
        session.removeAttribute("comboCart");
        session.removeAttribute("count");

        if (request.getParameter("changeStatus") != null) {
            if (Integer.parseInt(request.getParameter("changeStatus")) == 1) {
                request.getRequestDispatcher("thankyou.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("sorry_1.jsp").forward(request, response);
            }
        }
        else{
            request.getRequestDispatcher("thankyou.jsp").forward(request, response);
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
