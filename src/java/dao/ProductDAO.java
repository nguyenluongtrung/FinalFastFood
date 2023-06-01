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
            String sql = "select * from Product";

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

    public void createProduct(Product product) {
        try {
            String sql = "INSERT INTO [dbo].[Product]\n"
                    + "           ([Name]\n"
                    + "           ,[Image]\n"
                    + "           ,[CategoryID]\n"
                    + "           ,[Quantity]\n"
                    + "           ,[Calories]\n"
                    + "           ,[isSurprise]\n"
                    + "           ,[rating]\n"
                    + "           ,[AccumulatedPoint]\n"
                    + "           ,[ExchangedPoint])"
                    + "     VALUES (?,?,?,?,?,?,?,?,?)";

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setString(2, product.getImage());
            ps.setInt(3, product.getCategoryID());
            ps.setInt(4, product.getQuantity());
            ps.setInt(5, product.getCalories());
            ps.setBoolean(6, product.isIsSurprise());
            ps.setFloat(7, product.getRating());
            ps.setInt(8, product.getAccumulatedPoint());
            ps.setInt(9, product.getExchangedPoint());

            ps.executeUpdate();
        } catch (Exception ex) {
        }
    }

    public Product getProductUpdateById(int id) {

        String sql = "select*from Product where ProductID=?";

        try {
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getBoolean(7), rs.getFloat(8), rs.getInt(9), rs.getInt(10));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void delete(int id) {
        String sql = "delete from Product where ProductID=?";

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public boolean updateProduct(Product product) {
        boolean result = false;
        try {
            String sql = "UPDATE [dbo].[Product]\n"
                    + "   SET\n"
                    + "[Name] =?\n"
                    + "           ,[Image] =?\n"
                    + "           ,[CategoryID] =?\n"
                    + "           ,[Quantity] =?\n"
                    + "           ,[Calories] =?\n"
                    + "           ,[isSurprise] =?\n"
                    + "           ,[rating] =?\n"
                    + "           ,[AccumulatedPoint] =?\n"
                    + "           ,[ExchangedPoint] =? \n"
                    + " WHERE ProductID = ?";
            //mở connet đến SQL server
            conn = new DBContext().getConnection();

            //Câu lệnh cghauarn bị thực thi 
            ps = conn.prepareStatement(sql);
            ps.setString(1, product.getName());
            ps.setString(2, product.getImage());
            ps.setInt(3, product.getCategoryID());
            ps.setInt(4, product.getQuantity());
            ps.setInt(5, product.getCalories());
            ps.setBoolean(6, product.isIsSurprise());
            ps.setFloat(7, product.getRating());
            ps.setInt(8, product.getAccumulatedPoint());
            ps.setInt(9, product.getExchangedPoint());
            ps.setInt(10, product.getProductID());
            //Execute và return kết quả
            ps.executeUpdate();
            result = true;
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new ProductDAO().getProductByID(2));
    }
}
