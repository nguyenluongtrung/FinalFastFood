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
import model.SaleProduct;

/**
 *
 * @author ADMIN
 */
public class SaleProductDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public void createNewSaleDetail(int productID, int saleID, int quantity) {
        try {
            String sql = "INSERT INTO [dbo].[SaleProduct]\n"
                    + "           ([SaleID]\n"
                    + "           ,[ProductID]\n"
                    + "           ,[SaleQuantity])\n"
                    + "     VALUES\n"
                    + "           (?,?,?)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, saleID);
            ps.setInt(2, productID);
            ps.setInt(3, quantity);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SaleProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<SaleProduct> getAllCurrentSaleProducts() {
        List<SaleProduct> list = new ArrayList<>();
        try {
            String sql = "SELECT b.*, c.[Name] FROM Sale a JOIN SaleProduct b ON a.SaleID = b.SaleID JOIN Product c ON c.ProductID = b.ProductID WHERE GETDATE() BETWEEN a.StartDate AND a.EndDate";

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SaleProduct(rs.getInt(1), rs.getInt(2), rs.getString(4), rs.getInt(3)));
            }
        } catch (Exception ex) {
            Logger.getLogger(SaleProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<SaleProduct> getAllSaleProductsBySaleID(int saleID) {
        List<SaleProduct> list = new ArrayList<>();
        try {
            String sql = "SELECT b.*, c.[Name] FROM Sale a JOIN SaleProduct b ON a.SaleID = b.SaleID JOIN Product c ON c.ProductID = b.ProductID WHERE b.SaleID = ?";

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, saleID);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SaleProduct(rs.getInt(1), rs.getInt(2), rs.getString(4), rs.getInt(3)));
            }
        } catch (Exception ex) {
            Logger.getLogger(SaleProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void updateQuantity(int productID, int quantity, int saleID) {
        try {
            String sql = "UPDATE [dbo].[SaleProduct] SET [SaleQuantity] = SaleQuantity - ?  WHERE ProductID = ? and SaleID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, productID);
            ps.setInt(3, saleID);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SaleProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new SaleProductDAO().updateQuantity(2, 6, 6);
    }

    public void deleteSaleProductByID(int id) {
        try {
            String sql = "DELETE FROM [dbo].[SaleProduct]\n"
                    + "      WHERE SaleID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SaleProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
