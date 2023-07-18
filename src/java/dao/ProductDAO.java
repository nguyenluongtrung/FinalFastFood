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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CategoryRevenue;
import model.StatisticalProduct;
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
            String sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE a.EndDate is null";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public Product getProductByID(int id) {
        try {
            String sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.ProductID = ?) AND a.EndDate is null";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Product getSurpriseProduct() {
        try {
            String sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE b.isSurprise = 1 AND b.ProductStatus = 1 AND a.EndDate is null";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Product> getRelatedProducts(int id, int pID) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP 3 a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.CategoryID = ? and b.ProductID <> ?) AND a.EndDate is null";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, pID);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Product> getProductsByName(String name, int index) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.Name like ?) AND a.EndDate is null ORDER BY ProductID  OFFSET ? ROWS FETCH FIRST 15 ROWS ONLY";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ps.setInt(2, (index -1)*15);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int getProductsByName(String name) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.Name like ?) AND a.EndDate is null";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (list.size() % 15 == 0) ? (list.size() / 15) : (list.size() / 15 + 1);
    }

    public List<Product> getSomeProducts() {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP 6 a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE a.EndDate is null";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int searchByCalories(int from, int to) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "";
            if (to != -1) {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.Calories >= ?) AND (b.Calories <= ?) AND a.EndDate is null";
            } else {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.Calories >= ?) AND a.EndDate is null";
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
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (list.size() % 15 == 0) ? (list.size() / 15) : (list.size() / 15 + 1);
    }
    
    public List<Product> searchByCalories(int from, int to, int index) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "";
            if (to != -1) {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.Calories >= ?) AND (b.Calories <= ?) AND a.EndDate is null ORDER BY ProductID  OFFSET ? ROWS FETCH FIRST 15 ROWS ONLY";
            } else {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.Calories >= ?) AND a.EndDate is null ORDER BY ProductID  OFFSET ? ROWS FETCH FIRST 15 ROWS ONLY";
            }
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if (to != -1) {
                ps.setInt(1, from);
                ps.setInt(2, to);
                ps.setInt(3, (index - 1)*15);
            } else {
                ps.setInt(1, from);
                ps.setInt(2, (index - 1)*15);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<StatisticalProduct> getSpecialProducts(int type) {
        List<StatisticalProduct> list = new ArrayList<>();
        String sql = "";
        try {
            if (type == 1) {
                sql = "SELECT TOP 5 a.ProductID, b.Name, SUM(a.Quantity) as TotalQuantity FROM OrderDetail a JOIN Product b ON a.ProductID = b.ProductID \n"
                        + "GROUP BY a.ProductID, b.Name\n"
                        + "ORDER BY SUM(a.Quantity) DESC";
            } else {
                sql = "SELECT TOP 5 a.ProductID, b.Name, SUM(a.Quantity) as TotalQuantity FROM OrderDetail a JOIN Product b ON a.ProductID = b.ProductID WHERE b.isSurprise = 0 GROUP BY a.ProductID, b.Name ORDER BY SUM(a.Quantity) ";
            }

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new StatisticalProduct(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<CategoryRevenue> getAllCategoryRevenue() {
        List<CategoryRevenue> list = new ArrayList<>();
        try {
            String sql = "SELECT b.CategoryID, SUM(c.Price * a.Quantity) as TotalPrice, d.CategoryName FROM OrderDetail a JOIN Product b ON a.ProductID = b.ProductID JOIN Price c ON c.ProductID = b.ProductID JOIN Category d ON d.CategoryID = b.CategoryID GROUP BY b.CategoryID,d.CategoryName";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new CategoryRevenue(rs.getInt(1), rs.getFloat(2), rs.getString(3)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }

    public List<Product> getProductsByCategoryID(int categoryID) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "";
            if (categoryID == -1) {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID AND a.EndDate is null";
                conn = new DBContext().getConnection();

                ps = conn.prepareStatement(sql);

                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
                }
            } else {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.CategoryID = ?) AND a.EndDate is null";
                conn = new DBContext().getConnection();

                ps = conn.prepareStatement(sql);
                ps.setInt(1, categoryID);

                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Product> getProductsByCategoryID(int categoryID, int index) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "";
            if (categoryID == -1) {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID AND a.EndDate is null ORDER BY ProductID  OFFSET ? ROWS FETCH FIRST 15 ROWS ONLY";
                conn = new DBContext().getConnection();

                ps = conn.prepareStatement(sql);
                ps.setInt(1, (index -1)*15);

                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
                }
            } else {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.CategoryID = ?) AND a.EndDate is null ORDER BY ProductID  OFFSET ? ROWS FETCH FIRST 15 ROWS ONLY";
                conn = new DBContext().getConnection();

                ps = conn.prepareStatement(sql);
                ps.setInt(1, categoryID);
                ps.setInt(2, (index -1)*15);

                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int getPageNumberByCategoryID(int categoryID) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "";
            if (categoryID == -1) {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID AND a.EndDate is null";
                conn = new DBContext().getConnection();

                ps = conn.prepareStatement(sql);

                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
                }
            } else {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (b.CategoryID = ?) AND a.EndDate is null";
                conn = new DBContext().getConnection();

                ps = conn.prepareStatement(sql);
                ps.setInt(1, categoryID);

                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
                }
            }

        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (list.size() % 15 == 0) ? (list.size() / 15) : (list.size() / 15 + 1);
    }

    public List<Product> searchProductByPrice(float from, float to, int index) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "";
            if (to != -1) {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (a.Price >= ?) AND (a.Price <= ?) AND a.EndDate is null ORDER BY ProductID  OFFSET ? ROWS FETCH FIRST 15 ROWS ONLY";
            } else {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (a.Price >= ?) AND a.EndDate is null ORDER BY ProductID  OFFSET ? ROWS FETCH FIRST 15 ROWS ONLY";
            }
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if (to != -1) {
                ps.setFloat(1, from);
                ps.setFloat(2, to);
                ps.setInt(3, (index - 1) * 15);
            } else {
                ps.setFloat(1, from);
                ps.setInt(2, (index - 1) * 15);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void updateRating(float rating, int productID) {
        try {
            String sql = "UPDATE [dbo].[Product] SET [Rating]=? WHERE ProductID=?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setFloat(1, (float) Math.round(rating * 100) / 100);
            ps.setInt(2, productID);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int createProductReturnKey(String name, String image, int categoryID, int calories, int accPoint, int exPoint) {
        try {
            String sql = "INSERT INTO [dbo].[Product]\n"
                    + "           ([Name]\n"
                    + "           ,[Image]\n"
                    + "           ,[CategoryID]\n"
                    + "           ,[Calories]\n"
                    + "           ,[isSurprise]\n"
                    + "           ,[Rating]\n"
                    + "           ,[AccumulatedPoint]\n"
                    + "           ,[ExchangedPoint])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,0,5,?,?)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setInt(3, categoryID);
            ps.setInt(4, calories);
            ps.setInt(5, accPoint);
            ps.setInt(6, exPoint);

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public void deleteProductByID(int id) {
        try {
            String sql = "DELETE FROM [dbo].[Product]\n"
                    + "      WHERE ProductID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateProduct(int productID, String name, String image, int categoryID, int calories, int accPoint, int exPoint) {
        try {
            String sql = "UPDATE [dbo].[Product]\n"
                    + "   SET [Name] = ?\n"
                    + "      ,[Image] = ?\n"
                    + "      ,[CategoryID] = ?\n"
                    + "      ,[Calories] = ?\n"
                    + "      ,[AccumulatedPoint] = ?\n"
                    + "      ,[ExchangedPoint] = ?\n"
                    + " WHERE ProductID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setInt(3, categoryID);
            ps.setInt(4, calories);
            ps.setInt(5, accPoint);
            ps.setInt(6, exPoint);
            ps.setInt(7, productID);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateProductStatus(int productId, boolean status) {
        try {
            String sql = "UPDATE [dbo].[Product]\n"
                    + "   SET [ProductStatus] = ?\n"
                    + " WHERE ProductID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setBoolean(1, status);
            ps.setInt(2, productId);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        System.out.println(new ProductDAO().getProductsByName("c", 1));
    }

    public int createProductReturnKey(String name, String image, int categoryID, int calories, int accPoint, int exPoint, String p_startDate, String p_endDate) {
        try {
            String sql = "INSERT INTO [dbo].[Product]\n"
                    + "           ([Name]\n"
                    + "           ,[Image]\n"
                    + "           ,[CategoryID]\n"
                    + "           ,[Calories]\n"
                    + "           ,[isSurprise]\n"
                    + "           ,[Rating]\n"
                    + "           ,[AccumulatedPoint]\n"
                    + "           ,[ExchangedPoint]\n"
                    + "           ,[StartDate]\n"
                    + "           ,[EndDate])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,1\n"
                    + "           ,5\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setInt(3, categoryID);
            ps.setInt(4, calories);
            ps.setInt(5, accPoint);
            ps.setInt(6, exPoint);
            ps.setString(7, p_startDate);
            ps.setString(8, p_endDate);

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public void updateProduct(int productID, String name, String image, int categoryID, int calories, int accPoint, int exPoint, String p_startDate, String p_endDate) {
        try {
            String sql = "UPDATE [dbo].[Product]\n"
                    + "   SET [Name] = ?\n"
                    + "      ,[Image] = ?\n"
                    + "      ,[CategoryID] = ?\n"
                    + "      ,[Calories] = ?\n"
                    + "      ,[AccumulatedPoint] = ?\n"
                    + "      ,[ExchangedPoint] = ?\n"
                    + "      ,[StartDate] = ?\n"
                    + "      ,[EndDate] = ?\n"
                    + " WHERE ProductID = ? ";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, image);
            ps.setInt(3, categoryID);
            ps.setInt(4, calories);
            ps.setInt(5, accPoint);
            ps.setInt(6, exPoint);
            ps.setString(7, p_startDate);
            ps.setString(8, p_endDate);
            ps.setInt(9, productID);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Product> getAllProductsByPaging(int i) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE a.EndDate is null ORDER BY ProductID OFFSET ? ROWS FETCH FIRST 15 ROWS ONLY";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, (i - 1) * 15);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getNumberOfProductsAdmin() {
        try {
            String sql = "SELECT count(*) FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE a.EndDate is null";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getPageNumberShopping() {
        try {
            String sql = "SELECT count(*) FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE a.EndDate is null";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            if (rs.next()) {
                int num = rs.getInt(1);
                if (num % 15 == 0) {
                    return num / 15;
                } else {
                    return num / 15 + 1;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getPageNumberSearchProductByPrice(float from, float to) {
        List<Product> list = new ArrayList<>();
        try {
            String sql = "";
            if (to != -1) {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (a.Price >= ?) AND (a.Price <= ?) AND a.EndDate is null";
            } else {
                sql = "SELECT a.PriceID, a.StartDate, a.EndDate, a.Price, b.* FROM [FastFood].[dbo].[Price]  a JOIN [FastFood].[dbo].[Product] b ON b.ProductID = a.ProductID WHERE (a.Price >= ?) AND a.EndDate is null";
            }
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            if (to != -1) {
                ps.setFloat(1, from);
                ps.setFloat(2, to);
            } else {
                ps.setFloat(1, from);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getInt(9), rs.getBoolean(10), rs.getFloat(11), rs.getInt(12), rs.getInt(13), rs.getBoolean(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (list.size() % 15 == 0) ? (list.size() / 15) : (list.size() / 15 + 1);
    }

}
