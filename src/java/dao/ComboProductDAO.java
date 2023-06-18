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
public class ComboProductDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public void addNewComboDetail(int comboID, int proID, int quantity) {
        try {
            String sql = "INSERT INTO [dbo].[ComboProduct]\n"
                    + "           ([ComboID]\n"
                    + "           ,[ProductID]\n"
                    + "           ,[ProductQuantity])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, comboID);
            ps.setInt(2, proID);
            ps.setInt(3, quantity);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ComboProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteComboDetailsByID(int id) {
        try {
            String sql = "DELETE FROM [dbo].[ComboProduct]\n"
                    + "      WHERE ComboID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateComboDetail(int comboID, int proID, int quantity) {
        try {
            String sql = "UPDATE [dbo].[ComboProduct]\n"
                    + "   SET [ProductQuantity] = ?\n"
                    + " WHERE ComboID = ? and [ProductID] = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, comboID);
            ps.setInt(3, proID);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
