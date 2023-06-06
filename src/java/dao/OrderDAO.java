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

    public int addOrderReturnKey(float totalPrice, int shippingID, String note, int accountID) {
        try {
            String sql = "INSERT INTO [dbo].[Order]\n"
                    + "           ([TotalPrice]\n"
                    + "           ,[ShippingID]\n"
                    + "           ,[Note]\n"
                    + "           ,[Status]\n"
                    + "           ,[Date]\n"
                    + "           ,[AccountID])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,'PEND',GETDATE(),?)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setFloat(1, totalPrice);
            ps.setInt(2, shippingID);
            ps.setString(3, note);
            ps.setInt(4, accountID);

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
                    + "  FROM [FastFood].[dbo].[Order]\n"
                    + "  WHERE AccountID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, accountID);

            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Order(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println(new OrderDAO().getOrderByAccountID(4));
    }

}
