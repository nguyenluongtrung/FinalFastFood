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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class OrderDetailDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public void addOrderDetail(int orderID, int productID, int quantity) {
        try {
            String sql = "INSERT INTO [dbo].[OrderDetail]\n"
                    + "           ([OrderID]\n"
                    + "           ,[ProductID]\n"
                    + "           ,[Quantity])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, orderID);
            ps.setInt(2, productID);
            ps.setInt(3, quantity);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addComboOrderDetail(int orderID, int comboID, int quantity) {
        try {
            String sql = "INSERT INTO [dbo].[Combo_OrderDetail]\n"
                    + "           ([OrderID]\n"
                    + "           ,[ComboID]\n"
                    + "           ,[Quantity])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, orderID);
            ps.setInt(2, comboID);
            ps.setInt(3, quantity);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(OrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
