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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ComboDetails;

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
    
    public List<ComboDetails> getAllComboDetails(int comboID){
        List<ComboDetails> list = new ArrayList<>();
        try {
            String sql = "SELECT a.*, b.ProductID, b.ProductQuantity, c.[Name], c.ProductStatus FROM Combo a JOIN ComboProduct b ON a.ComboID = b.ComboID JOIN Product c ON c.ProductID = b.ProductID WHERE a.ComboID = ?";
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, comboID);
            
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new ComboDetails(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getString(11), rs.getBoolean(12)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ComboProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println(new ComboProductDAO().getAllComboDetails(1));
    }

}
