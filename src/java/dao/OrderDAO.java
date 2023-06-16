/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;

/**
 *
 * @author ADMIN
 */
public class OrderDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public int addOrderReturnKey(float totalPrice, int shippingID, String note, int accountID, boolean isSale) {
        try {
            String sql = "INSERT INTO [dbo].[Order]\n"
                    + "           ([TotalPrice]\n"
                    + "           ,[ShippingID]\n"
                    + "           ,[Note]\n"
                    + "           ,[Status]\n"
                    + "           ,[Date]\n"
                    + "           ,[AccountID]"
                    + "           ,[isSale])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,'PEND',GETDATE(),?,?)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setFloat(1, totalPrice);
            ps.setInt(2, shippingID);
            ps.setString(3, note);
            ps.setInt(4, accountID);
            ps.setBoolean(5, isSale);

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public List<Order> getOrderByAccountID(int accountID) {
        List<Order> list = new ArrayList<>();
        try {
            String sql = "SELECT [OrderID]\n"
                    + "      ,[TotalPrice]\n"
                    + "      ,[ShippingID]\n"
                    + "      ,[Note]\n"
                    + "      ,[Status]\n"
                    + "      ,[Date]\n"
                    + "      ,[AccountID]\n"
                    + "      ,[isSale]\n"
                    + "  FROM [dbo].[Order]"
                    + "  WHERE AccountID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, accountID);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getFloat(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getBoolean(8)));
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new OrderDAO().getAllOrders());
    }

    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        try {
            String sql = "SELECT [OrderID]\n"
                    + "      ,[TotalPrice]\n"
                    + "      ,[ShippingID]\n"
                    + "      ,[Note]\n"
                    + "      ,[Status]\n"
                    + "      ,[Date]\n"
                    + "      ,[AccountID]\n"
                    + "      ,[isSale]\n"
                    + "  FROM [dbo].[Order]";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(new Order(rs.getInt(1), rs.getFloat(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getBoolean(8)));
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

    public List<Order> sortOrderByPrice(int ok) {
        List<Order> list = new ArrayList<>();
        try {
            String sql = "";
            if (ok == 1) {
                sql = "SELECT [OrderID]\n"
                        + "      ,[TotalPrice]\n"
                        + "      ,[ShippingID]\n"
                        + "      ,[Note]\n"
                        + "      ,[Status]\n"
                        + "      ,[Date]\n"
                        + "      ,[AccountID]\n"
                        + "      ,[isSale]\n"
                        + "  FROM [dbo].[Order]"
                        + "  ORDER BY TotalPrice";
            } else {
                sql = "SELECT [OrderID]\n"
                        + "      ,[TotalPrice]\n"
                        + "      ,[ShippingID]\n"
                        + "      ,[Note]\n"
                        + "      ,[Status]\n"
                        + "      ,[Date]\n"
                        + "      ,[AccountID]\n"
                        + "      ,[isSale]\n"
                        + "  FROM [dbo].[Order]"
                        + "  ORDER BY TotalPrice DESC";
            }

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getFloat(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getBoolean(8)));
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void updateOrderStatus(int orderID, String status) {
        try {
            String sql = "UPDATE [dbo].[Order] SET status = ? WHERE orderID = ?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, orderID);

            ps.executeUpdate();
        } catch (Exception e) {
            Logger.getLogger(PriceDAO.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public Order getOrderByID(int id) {
        try {
            String sql = "SELECT [OrderID]\n"
                    + "      ,[TotalPrice]\n"
                    + "      ,[ShippingID]\n"
                    + "      ,[Note]\n"
                    + "      ,[Status]\n"
                    + "      ,[Date]\n"
                    + "      ,[AccountID]\n"
                    + "      ,[isSale]\n"
                    + "  FROM [dbo].[Order]"
                    + "  WHERE OrderID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Order(rs.getInt(1), rs.getFloat(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getBoolean(8));
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
