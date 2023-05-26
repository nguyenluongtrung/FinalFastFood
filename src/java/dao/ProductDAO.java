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

    public List<Product> getAllProducts() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT [ProductID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Image]\n"
                    + "      ,[CategoryID]\n"
                    + "      ,[Quantity]\n"
                    + "      ,[Calories]\n"
                    + "      ,[isSurprise]\n"
                    + "      ,[Rating]\n"
                    + "      ,[AccumulatedPoint]\n"
                    + "      ,[ExchangedPoint]\n"
                    + "  FROM [dbo].[Product]";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getBoolean(7), rs.getFloat(8), rs.getInt(9), rs.getInt(10)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public Product getProductByID(int id) {
        try {
            String sql = "SELECT [ProductID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Image]\n"
                    + "      ,[CategoryID]\n"
                    + "      ,[Quantity]\n"
                    + "      ,[Calories]\n"
                    + "      ,[isSurprise]\n"
                    + "      ,[Rating]\n"
                    + "      ,[AccumulatedPoint]\n"
                    + "      ,[ExchangedPoint]\n"
                    + "  FROM [dbo].[Product]\n"
                    + "  WHERE ProductID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getBoolean(7), rs.getFloat(8), rs.getInt(9), rs.getInt(10));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Product> getRelatedProducts(int id, int pID) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP 3 [ProductID]\n"
                    + "      ,[Name]\n"
                    + "      ,[Image]\n"
                    + "      ,[CategoryID]\n"
                    + "      ,[Quantity]\n"
                    + "      ,[Calories]\n"
                    + "      ,[isSurprise]\n"
                    + "      ,[Rating]\n"
                    + "      ,[AccumulatedPoint]\n"
                    + "      ,[ExchangedPoint]\n"
                    + "  FROM [dbo].[Product]\n"
                    + "  WHERE CategoryID = ? and ProductID <> ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, pID);

            rs = ps.executeQuery();
            while (rs.next()) {
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

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");

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
        System.out.println(new ProductDAO().getProductByID(2));
    }
}
