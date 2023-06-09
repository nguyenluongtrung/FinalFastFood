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
public class PriceDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public void deletePriceByProductID(int id) {
        try {
            String sql = "DELETE FROM [dbo].[Price]\n"
                    + "      WHERE ProductID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(PriceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void createNewPrice(int productID, float price) {
        try {
            String sql = "INSERT INTO [dbo].[Price]\n"
                    + "           ([StartDate]\n"
                    + "           ,[EndDate]\n"
                    + "           ,[ProductID]\n"
                    + "           ,[Price])\n"
                    + "     VALUES\n"
                    + "           (GETDATE()\n"
                    + "           ,null\n"
                    + "           ,?\n"
                    + "           ,?)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, productID);
            ps.setFloat(2, price);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(PriceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatePriceByPriceID(int priceID) {
        try {
            String sql = "UPDATE [dbo].[Price]\n"
                    + "   SET [EndDate] = GETDATE()\n"
                    + " WHERE PriceID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, priceID);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(PriceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getPriceID(int productID, String s_date) {
        try {
            String sql = "SELECT [PriceID]\n"
                    + "  FROM [dbo].[Price]\n"
                    + "  WHERE [StartDate] = ? AND ProductID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, s_date);
            ps.setInt(2, productID);

            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(PriceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

}
