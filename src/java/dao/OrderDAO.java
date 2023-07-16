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
    
    public List<Integer> getOrderIDByAccountID(int accountID) {
        List<Integer> list = new ArrayList<>();
        try {
            String sql = "SELECT [OrderID]\n"
                    + "  FROM [dbo].[Order]"
                    + "  WHERE AccountID = ?";
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, accountID);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
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
                    + "  FROM [dbo].[Order]\n"
                    + "  Order by [Date] DESC";
            
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
    
    public List<Order> sortOrderByPrice(int ok, int index) {
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
                        + "  ORDER BY TotalPrice ASC, [Date] DESC  OFFSET ? ROWS FETCH FIRST 20 ROWS ONLY";
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
                        + "  ORDER BY TotalPrice DESC, [Date] DESC  OFFSET ? ROWS FETCH FIRST 20 ROWS ONLY";
            }
            
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if (ok == 1) {
                ps.setInt(1, 20 * (index - 1));
            } else {
                ps.setInt(1, 20 * (index - 1));
            }
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
    
    public List<Order> searchOrderByTime(int i, int year, int month, int date, int index) {
        List<Order> list = new ArrayList<>();
        try {
            String sql = "";
            switch (i) {
                case 1:
                    sql = "SELECT [OrderID]\n"
                            + "      ,[TotalPrice]\n"
                            + "      ,[ShippingID]\n"
                            + "      ,[Note]\n"
                            + "      ,[Status]\n"
                            + "      ,[Date]\n"
                            + "      ,[AccountID]\n"
                            + "      ,[isSale]\n"
                            + "  FROM [FastFood].[dbo].[Order]\n"
                            + "  WHERE YEAR([Date]) = ? and DAY([Date]) = ? and MONTH([Date]) = ? Order by [Date] DESC OFFSET ? ROWS FETCH FIRST 20 ROWS ONLY";
                    break;
                case 2:
                    sql = "SELECT [OrderID]\n"
                            + "      ,[TotalPrice]\n"
                            + "      ,[ShippingID]\n"
                            + "      ,[Note]\n"
                            + "      ,[Status]\n"
                            + "      ,[Date]\n"
                            + "      ,[AccountID]\n"
                            + "      ,[isSale]\n"
                            + "  FROM [FastFood].[dbo].[Order]\n"
                            + "  WHERE YEAR([Date]) = ? and MONTH([Date]) = ? Order by [Date] DESC OFFSET ? ROWS FETCH FIRST 20 ROWS ONLY";
                    break;
                case 3:
                    sql = "SELECT [OrderID]\n"
                            + "      ,[TotalPrice]\n"
                            + "      ,[ShippingID]\n"
                            + "      ,[Note]\n"
                            + "      ,[Status]\n"
                            + "      ,[Date]\n"
                            + "      ,[AccountID]\n"
                            + "      ,[isSale]\n"
                            + "  FROM [FastFood].[dbo].[Order]\n"
                            + "  WHERE YEAR([Date]) = ? and DAY([Date]) = ? Order by [Date] DESC OFFSET ? ROWS FETCH FIRST 20 ROWS ONLY";
                    break;
                case 4:
                    sql = "SELECT [OrderID]\n"
                            + "      ,[TotalPrice]\n"
                            + "      ,[ShippingID]\n"
                            + "      ,[Note]\n"
                            + "      ,[Status]\n"
                            + "      ,[Date]\n"
                            + "      ,[AccountID]\n"
                            + "      ,[isSale]\n"
                            + "  FROM [FastFood].[dbo].[Order]\n"
                            + "  WHERE YEAR([Date]) = ? Order by [Date] DESC OFFSET ? ROWS FETCH FIRST 20 ROWS ONLY";
                    break;
                case 5:
                    sql = "SELECT [OrderID]\n"
                            + "      ,[TotalPrice]\n"
                            + "      ,[ShippingID]\n"
                            + "      ,[Note]\n"
                            + "      ,[Status]\n"
                            + "      ,[Date]\n"
                            + "      ,[AccountID]\n"
                            + "      ,[isSale]\n"
                            + "  FROM [FastFood].[dbo].[Order]\n"
                            + "  WHERE MONTH([Date]) = ? AND DAY([Date]) = ? Order by [Date] DESC OFFSET ? ROWS FETCH FIRST 20 ROWS ONLY";
                    break;
                case 6:
                    sql = "SELECT [OrderID]\n"
                            + "      ,[TotalPrice]\n"
                            + "      ,[ShippingID]\n"
                            + "      ,[Note]\n"
                            + "      ,[Status]\n"
                            + "      ,[Date]\n"
                            + "      ,[AccountID]\n"
                            + "      ,[isSale]\n"
                            + "  FROM [FastFood].[dbo].[Order]\n"
                            + "  WHERE MONTH([Date]) = ? Order by [Date] DESC OFFSET ? ROWS FETCH FIRST 20 ROWS ONLY";
                    break;
                case 7:
                    sql = "SELECT [OrderID]\n"
                            + "      ,[TotalPrice]\n"
                            + "      ,[ShippingID]\n"
                            + "      ,[Note]\n"
                            + "      ,[Status]\n"
                            + "      ,[Date]\n"
                            + "      ,[AccountID]\n"
                            + "      ,[isSale]\n"
                            + "  FROM [FastFood].[dbo].[Order]\n"
                            + "  WHERE DAY([Date]) = ? Order by [Date] DESC OFFSET ? ROWS FETCH FIRST 20 ROWS ONLY";
                    break;
            }
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            switch (i) {
                case 1:
                    ps.setInt(1, year);
                    ps.setInt(2, date);
                    ps.setInt(3, month);
                    ps.setInt(4, (index - 1) * 20);
                    break;
                case 2:
                    ps.setInt(1, year);
                    ps.setInt(2, month);
                    ps.setInt(3, (index - 1) * 20);
                    break;
                case 3:
                    ps.setInt(1, year);
                    ps.setInt(2, date);
                    ps.setInt(3, (index - 1) * 20);
                    break;
                case 4:
                    ps.setInt(1, year);
                    ps.setInt(2, (index - 1) * 20);
                    break;
                case 5:
                    ps.setInt(1, month);
                    ps.setInt(2, date);
                    ps.setInt(3, (index - 1) * 20);
                    break;
                case 6:
                    ps.setInt(1, month);
                    ps.setInt(2, (index - 1) * 20);
                    break;
                case 7:
                    ps.setInt(1, date);
                    ps.setInt(2, (index - 1) * 20);
                    break;
            }
            
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getFloat(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getBoolean(8)));
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Order> searchOrderByTime(int i, int year, int month, int date) {
        List<Order> list = new ArrayList<>();
        try {
            String sql = "";
            switch (i) {
                case 1:
                    sql = "SELECT [OrderID]\n"
                            + "      ,[TotalPrice]\n"
                            + "      ,[ShippingID]\n"
                            + "      ,[Note]\n"
                            + "      ,[Status]\n"
                            + "      ,[Date]\n"
                            + "      ,[AccountID]\n"
                            + "      ,[isSale]\n"
                            + "  FROM [FastFood].[dbo].[Order]\n"
                            + "  WHERE YEAR([Date]) = ? and DAY([Date]) = ? and MONTH([Date]) = ? Order by [Date] DESC";
                    break;
                case 2:
                    sql = "SELECT [OrderID]\n"
                            + "      ,[TotalPrice]\n"
                            + "      ,[ShippingID]\n"
                            + "      ,[Note]\n"
                            + "      ,[Status]\n"
                            + "      ,[Date]\n"
                            + "      ,[AccountID]\n"
                            + "      ,[isSale]\n"
                            + "  FROM [FastFood].[dbo].[Order]\n"
                            + "  WHERE YEAR([Date]) = ? and MONTH([Date]) = ? Order by [Date] DESC";
                    break;
                case 3:
                    sql = "SELECT [OrderID]\n"
                            + "      ,[TotalPrice]\n"
                            + "      ,[ShippingID]\n"
                            + "      ,[Note]\n"
                            + "      ,[Status]\n"
                            + "      ,[Date]\n"
                            + "      ,[AccountID]\n"
                            + "      ,[isSale]\n"
                            + "  FROM [FastFood].[dbo].[Order]\n"
                            + "  WHERE YEAR([Date]) = ? and DAY([Date]) = ? Order by [Date] DESC";
                    break;
                case 4:
                    sql = "SELECT [OrderID]\n"
                            + "      ,[TotalPrice]\n"
                            + "      ,[ShippingID]\n"
                            + "      ,[Note]\n"
                            + "      ,[Status]\n"
                            + "      ,[Date]\n"
                            + "      ,[AccountID]\n"
                            + "      ,[isSale]\n"
                            + "  FROM [FastFood].[dbo].[Order]\n"
                            + "  WHERE YEAR([Date]) = ? Order by [Date] DESC";
                    break;
                case 5:
                    sql = "SELECT [OrderID]\n"
                            + "      ,[TotalPrice]\n"
                            + "      ,[ShippingID]\n"
                            + "      ,[Note]\n"
                            + "      ,[Status]\n"
                            + "      ,[Date]\n"
                            + "      ,[AccountID]\n"
                            + "      ,[isSale]\n"
                            + "  FROM [FastFood].[dbo].[Order]\n"
                            + "  WHERE MONTH([Date]) = ? AND DAY([Date]) = ? Order by [Date] DESC";
                    break;
                case 6:
                    sql = "SELECT [OrderID]\n"
                            + "      ,[TotalPrice]\n"
                            + "      ,[ShippingID]\n"
                            + "      ,[Note]\n"
                            + "      ,[Status]\n"
                            + "      ,[Date]\n"
                            + "      ,[AccountID]\n"
                            + "      ,[isSale]\n"
                            + "  FROM [FastFood].[dbo].[Order]\n"
                            + "  WHERE MONTH([Date]) = ? Order by [Date] DESC";
                    break;
                case 7:
                    sql = "SELECT [OrderID]\n"
                            + "      ,[TotalPrice]\n"
                            + "      ,[ShippingID]\n"
                            + "      ,[Note]\n"
                            + "      ,[Status]\n"
                            + "      ,[Date]\n"
                            + "      ,[AccountID]\n"
                            + "      ,[isSale]\n"
                            + "  FROM [FastFood].[dbo].[Order]\n"
                            + "  WHERE DAY([Date]) = ? Order by [Date] DESC";
                    break;
            }
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            switch (i) {
                case 1:
                    ps.setInt(1, year);
                    ps.setInt(2, date);
                    ps.setInt(3, month);
                    break;
                case 2:
                    ps.setInt(1, year);
                    ps.setInt(2, month);
                    break;
                case 3:
                    ps.setInt(1, year);
                    ps.setInt(2, date);
                    break;
                case 4:
                    ps.setInt(1, year);
                    break;
                case 5:
                    ps.setInt(1, month);
                    ps.setInt(2, date);
                    break;
                case 6:
                    ps.setInt(1, month);
                    break;
                case 7:
                    ps.setInt(1, date);
                    break;
            }
            
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getFloat(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getBoolean(8)));
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int getNumberPageOrder() {
        try {
            String sql = "SELECT count(*)\n"
                    + "  FROM [dbo].[Order]";
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            if (rs.next()) {
                int total = rs.getInt(1);
                if (total % 20 == 0) {
                    return total / 20;
                } else {
                    return total / 20 + 1;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public List<Order> getOrdersByPage(int index) {
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
                    + "  FROM [FastFood].[dbo].[Order]\n"
                    + "  ORDER BY [Date] DESC\n"
                    + "  OFFSET ? ROWS FETCH FIRST 20 ROWS ONLY";
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 20);
            
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
        System.out.println(new OrderDAO().getAllProductIDByOrderID(10));
    }
    
    public int getNumberPageOrderByAccID(int accountID) {
        try {
            String sql = "SELECT count(*)\n"
                    + "  FROM [dbo].[Order]\n"
                    + "  Where AccountID = ?";
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, accountID);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                int total = rs.getInt(1);
                if (total % 20 == 0) {
                    return total / 20;
                } else {
                    return total / 20 + 1;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public List<Order> getOrderByAccountIDPaging(int accountID, int i) {
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
                    + "  WHERE AccountID = ? Order by [Date] DESC OFFSET ? ROWS FETCH FIRST 20 ROWS ONLY";
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, accountID);
            ps.setInt(2, (i - 1) * 20);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Order(rs.getInt(1), rs.getFloat(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getBoolean(8)));
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Integer> getAllProductIDByOrderID(int orderID) {
        List<Integer> list = new ArrayList<>();
        try {
            String sql = "SELECT [ProductID]\n"
                    + "  FROM [dbo].[OrderDetail]\n"
                    + "  WHERE OrderID = ?";
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, orderID);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getInt(1));
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
