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
import model.Product;

/**
 *
 * @author ADMIN
 */
public class ProductDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public List<Product> getAllProducts(){
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT [ProductID]\n" +
                    "      ,[Name]\n" +
                    "      ,[Image]\n" +
                    "      ,[CategoryID]\n" +
                    "      ,[Quantity]\n" +
                    "      ,[Calories]\n" +
                    "      ,[isSurprise]\n" +
                    "      ,[Rating]\n" +
                    "      ,[AccumulatedPoint]\n" +
                    "      ,[ExchangedPoint]\n" +
                    "  FROM [dbo].[Product]";
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getBoolean(7), rs.getFloat(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
    
     public List<Product> getProductsByName(String name, int index) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Product "
                    + "WHERE Name like ?";
//                    + "ORDER BY ProductID OFFSET ? ROWS FETCH NEXT 9 ROWS ONLY;";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
//            ps.setInt(2, 9 * (index - 1));

            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getBoolean(7), rs.getFloat(8), rs.getInt(9), rs.getInt(10));
                list.add(product);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println(new ProductDAO().getAllProducts());
    }
}
