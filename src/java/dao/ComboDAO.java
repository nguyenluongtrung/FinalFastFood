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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Combo;
import model.ComboInfoOrderDetail;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class ComboDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public int addNewComboReturnKey(String comboName, int totalCalories, float totalPrice, int exPoint, int accPoint) {
        try {
            String sql = "INSERT INTO [dbo].[Combo]\n"
                    + "           ([ComboName]\n"
                    + "           ,[Image]\n"
                    + "           ,[TotalCalories]\n"
                    + "           ,[TotalPrice]\n"
                    + "           ,[Rating]\n"
                    + "           ,[AccumulatedPoint]\n"
                    + "           ,[ExchangedPoint])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,5\n"
                    + "           ,?\n"
                    + "           ,?)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comboName);
            ps.setString(2, "image/combo.jpg");
            ps.setInt(3, totalCalories);
            ps.setFloat(4, totalPrice);
            ps.setInt(5, accPoint);
            ps.setInt(6, exPoint);

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public List<Combo> getAllCombos() {
        List<Combo> list = new ArrayList<>();
        try {
            String sql = "SELECT [ComboID]\n"
                    + "      ,[ComboName]\n"
                    + "      ,[Image]\n"
                    + "      ,[TotalCalories]\n"
                    + "      ,[TotalPrice]\n"
                    + "      ,[Rating]\n"
                    + "      ,[AccumulatedPoint]\n"
                    + "      ,[ExchangedPoint]\n"
                    + "  FROM [FastFood].[dbo].[Combo]";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Combo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new ComboDAO().getAllComboOrderDetailByOrderID(71));
    }

    public Combo getComboByID(int id) {
        try {
            String sql = "SELECT [ComboID]\n"
                    + "      ,[ComboName]\n"
                    + "      ,[Image]\n"
                    + "      ,[TotalCalories]\n"
                    + "      ,[TotalPrice]\n"
                    + "      ,[Rating]\n"
                    + "      ,[AccumulatedPoint]\n"
                    + "      ,[ExchangedPoint]\n"
                    + "  FROM [dbo].[Combo]\n"
                    + "  WHERE ComboID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Combo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6), rs.getInt(7), rs.getInt(8));
            }
        } catch (Exception ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Combo> getRelatedCombos(int id) {
        List<Combo> list = new ArrayList<>();
        try {
            String sql = "SELECT TOP 3 [ComboID]\n"
                    + "      ,[ComboName]\n"
                    + "      ,[Image]\n"
                    + "      ,[TotalCalories]\n"
                    + "      ,[TotalPrice]\n"
                    + "      ,[Rating]\n"
                    + "      ,[AccumulatedPoint]\n"
                    + "      ,[ExchangedPoint]\n"
                    + "  FROM [dbo].[Combo]\n"
                    + "  WHERE ComboID <> ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Combo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public void deleteComboByID(int id) {
        try {
            String sql = "DELETE FROM [dbo].[Combo]\n"
                    + "      WHERE ComboID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateCombo(int comboID, String comboName, float totalPrice, int exPoint, int accPoint) {
        try {
            String sql = "UPDATE [dbo].[Combo]\n"
                    + "   SET [ComboName] = ?\n"
                    + "      ,[TotalPrice] = ?\n"
                    + "      ,[AccumulatedPoint] = ?\n"
                    + "      ,[ExchangedPoint] = ?\n"
                    + " WHERE ComboID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, comboName);
            ps.setFloat(2, totalPrice);
            ps.setInt(3, accPoint);
            ps.setInt(4, exPoint);
            ps.setInt(5, comboID);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Combo> searchComboByPrice(float from, float to) {
        List<Combo> list = new ArrayList<>();
        try {
            String sql = "";
            if (to != -1) {
                sql = "SELECT [ComboID]\n"
                        + "      ,[ComboName]\n"
                        + "      ,[Image]\n"
                        + "      ,[TotalCalories]\n"
                        + "      ,[TotalPrice]\n"
                        + "      ,[Rating]\n"
                        + "      ,[AccumulatedPoint]\n"
                        + "      ,[ExchangedPoint]\n"
                        + "  FROM [dbo].[Combo]\n"
                        + "  WHERE (TotalPrice >= ?) and (TotalPrice <= ?)";
            } else {
                sql = "SELECT [ComboID]\n"
                        + "      ,[ComboName]\n"
                        + "      ,[Image]\n"
                        + "      ,[TotalCalories]\n"
                        + "      ,[TotalPrice]\n"
                        + "      ,[Rating]\n"
                        + "      ,[AccumulatedPoint]\n"
                        + "      ,[ExchangedPoint]\n"
                        + "  FROM [dbo].[Combo]\n"
                        + "  WHERE TotalPrice >= ?";
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
                list.add(new Combo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<Combo> searchByCalories(int from, int to) {
        List<Combo> list = new ArrayList<>();
        try {
            String sql = "";
            if (to != -1) {
                sql = "SELECT [ComboID]\n"
                        + "      ,[ComboName]\n"
                        + "      ,[Image]\n"
                        + "      ,[TotalCalories]\n"
                        + "      ,[TotalPrice]\n"
                        + "      ,[Rating]\n"
                        + "      ,[AccumulatedPoint]\n"
                        + "      ,[ExchangedPoint]\n"
                        + "  FROM [dbo].[Combo]\n"
                        + "  WHERE (TotalCalories >= ?) and (TotalCalories <= ?)";
            } else {
                sql = "SELECT [ComboID]\n"
                        + "      ,[ComboName]\n"
                        + "      ,[Image]\n"
                        + "      ,[TotalCalories]\n"
                        + "      ,[TotalPrice]\n"
                        + "      ,[Rating]\n"
                        + "      ,[AccumulatedPoint]\n"
                        + "      ,[ExchangedPoint]\n"
                        + "  FROM [dbo].[Combo]\n"
                        + "  WHERE TotalCalories >= ?";
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
                list.add(new Combo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6), rs.getInt(7), rs.getInt(8)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<ComboInfoOrderDetail> getAllComboOrderDetailByOrderID(int id) {
        List<ComboInfoOrderDetail> list = new ArrayList<>();
        try {
            String sql = "SELECT b.ComboID, b.Quantity, c.ComboName, c.TotalPrice, c.TotalCalories, c.AccumulatedPoint FROM [Order] a JOIN Combo_OrderDetail b ON a.OrderID = b.OrderID JOIN Combo c ON c.ComboID = b.ComboID WHERE a.OrderID = ?";
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new ComboInfoOrderDetail(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getInt(6)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ComboDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
