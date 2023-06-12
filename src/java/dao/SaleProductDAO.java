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
    
    public List<SaleProduct> getAllCurrentSaleProducts(){
        List<SaleProduct> list = new ArrayList<>();
        try {
            String sql = "SELECT b.* FROM Sale a JOIN SaleProduct b ON a.SaleID = b.SaleID WHERE GETDATE() BETWEEN a.StartDate AND a.EndDate";
            
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new SaleProduct(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
            }
        } catch (Exception ex) {
            Logger.getLogger(SaleProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new SaleProductDAO().getAllCurrentSaleProducts());
    }
}
