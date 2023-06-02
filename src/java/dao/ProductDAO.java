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
import model.CategoryRevenue;
import model.HotProduct;
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
            String sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE GETDATE() BETWEEN a.StartDate AND a.EndDate";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getBoolean(11), rs.getFloat(12), rs.getInt(13), rs.getInt(14)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public Product getProductByID(int id) {
        try {
            String sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.ProductID = ?) AND (GETDATE() BETWEEN a.StartDate AND a.EndDate)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getBoolean(11), rs.getFloat(12), rs.getInt(13), rs.getInt(14));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Product> getRelatedProducts(int id, int pID) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP 3 a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.CategoryID = ? and b.ProductID <> ?) AND (GETDATE() BETWEEN a.StartDate AND a.EndDate)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, pID);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getBoolean(11), rs.getFloat(12), rs.getInt(13), rs.getInt(14)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Product> getProductsByName(String name, int index) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.Name like ?) AND (GETDATE() BETWEEN a.StartDate AND a.EndDate)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getBoolean(11), rs.getFloat(12), rs.getInt(13), rs.getInt(14)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Product> getSomeProducts() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP 6 a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (GETDATE() BETWEEN a.StartDate AND a.EndDate)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getBoolean(11), rs.getFloat(12), rs.getInt(13), rs.getInt(14)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new ProductDAO().getAllProducts());
    }

    public void updateQuantity(int productID, int quantity) {
        try {
            String sql = "UPDATE [dbo].[Product]\n"
                    + "   SET [Quantity] = [Quantity] - ?\n"
                    + " WHERE ProductID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, quantity);
            ps.setInt(2, productID);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Product> searchByCalories(int from, int to) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "";
            if (to != -1) {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.Calories >= ?) AND (b.Calories <= ?) AND (GETDATE() BETWEEN a.StartDate AND a.EndDate)";
            } else {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.Calories >= ?) AND (GETDATE() BETWEEN a.StartDate AND a.EndDate)";
            }
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if (to != -1) {
                ps.setInt(1, from);
                ps.setInt(2, to);
            } else {
                ps.setInt(1, from);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getBoolean(11), rs.getFloat(12), rs.getInt(13), rs.getInt(14)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<HotProduct> getAllHotProducts() {
        List<HotProduct> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP 5 a.ProductID, b.Name, SUM(a.Quantity) as TotalQuantity FROM OrderDetail a JOIN Product b ON a.ProductID = b.ProductID \n"
                    + "GROUP BY a.ProductID, b.Name\n"
                    + "ORDER BY SUM(a.Quantity) DESC";
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new HotProduct(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<CategoryRevenue> getAllCategoryRevenue(){
        List<CategoryRevenue> list = new ArrayList<>();
        try {
            String sql = "SELECT b.CategoryID, SUM(c.Price) as TotalPrice, d.CategoryName FROM OrderDetail a JOIN Product b ON a.ProductID = b.ProductID JOIN Price c ON c.ProductID = b.ProductID JOIN Category d ON d.CategoryID = b.CategoryID GROUP BY b.CategoryID,d.CategoryName";
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new CategoryRevenue(rs.getInt(1), rs.getInt(2), rs.getString(3)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
        
    }
}
