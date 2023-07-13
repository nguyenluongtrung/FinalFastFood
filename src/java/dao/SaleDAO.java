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
import model.Sale;

/**
 *
 * @author ADMIN
 */
public class SaleDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public List<Sale> getAllSales() {
        List<Sale> list = new ArrayList<>();
        try {
            String sql = "SELECT [SaleID]\n"
                    + "      ,[SaleValue]\n"
                    + "      ,[StartDate]\n"
                    + "      ,[EndDate]\n"
                    + "      ,[SaleName]\n"
                    + "      ,[SaleCode]\n"
                    + "  FROM [dbo].[Sale]";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Sale(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception ex) {
            Logger.getLogger(SaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getNumberPageSale() {
        try {
            String sql = "SELECT count(*)\n"
                    + "  FROM [FastFood].[dbo].[Sale]";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            if (rs.next()) {
                int num = rs.getInt(1);
                if(num % 20 == 0){
                    return num / 20;
                }
                else{
                    return num / 20 + 1;
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(SaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }

    public void deleteSaleByID(int id) {
        try {
            String sql = "DELETE FROM [dbo].[Sale]\n"
                    + "      WHERE SaleID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int addNewSaleReturnKey(String name, float value, String code, String s_date, String e_date) {
        try {
            String sql = "INSERT INTO [dbo].[Sale]\n"
                    + "           ([SaleValue]\n"
                    + "           ,[StartDate]\n"
                    + "           ,[EndDate]\n"
                    + "           ,[SaleName]\n"
                    + "           ,[SaleCode])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?)";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setFloat(1, value);
            ps.setString(2, s_date);
            ps.setString(3, e_date);
            ps.setString(4, name);
            ps.setString(5, code);

            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(SaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public void updateSale(int id, String name, float value, String code, String s_date, String e_date) {
        try {
            String sql = "UPDATE [dbo].[Sale]\n"
                    + "   SET [SaleValue] = ?\n"
                    + "      ,[StartDate] = ?\n"
                    + "      ,[EndDate] = ?\n"
                    + "      ,[SaleName] = ?\n"
                    + "      ,[SaleCode] = ?\n"
                    + " WHERE SaleID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setFloat(1, value);
            ps.setString(2, s_date);
            ps.setString(3, e_date);
            ps.setString(4, name);
            ps.setString(5, code);
            ps.setInt(6, id);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Sale getSaleByID(int id) {
        try {
            String sql = "SELECT [SaleID]\n"
                    + "      ,[SaleValue]\n"
                    + "      ,[StartDate]\n"
                    + "      ,[EndDate]\n"
                    + "      ,[SaleName]\n"
                    + "      ,[SaleCode]\n"
                    + "  FROM [dbo].[Sale]\n"
                    + "  WHERE SaleID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Sale(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception ex) {
            Logger.getLogger(SaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Sale getSaleByDate() {
        try {
            String sql = "SELECT [SaleID]\n"
                    + "      ,[SaleValue]\n"
                    + "      ,[StartDate]\n"
                    + "      ,[EndDate]\n"
                    + "      ,[SaleName]\n"
                    + "      ,[SaleCode]\n"
                    + "  FROM [dbo].[Sale]\n"
                    + "  WHERE GETDATE() BETWEEN StartDate AND EndDate";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Sale(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception ex) {
            Logger.getLogger(SaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Sale getSaleByOrderDate(String date) {
        try {
            String sql = "SELECT [SaleID]\n"
                    + "      ,[SaleValue]\n"
                    + "      ,[StartDate]\n"
                    + "      ,[EndDate]\n"
                    + "      ,[SaleName]\n"
                    + "      ,[SaleCode]\n"
                    + "  FROM [FastFood].[dbo].[Sale]\n"
                    + "  WHERE StartDate <= ? and ? <= EndDate";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, date);
            ps.setString(2, date);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Sale(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception ex) {
            Logger.getLogger(SaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new SaleDAO().getNumberPageSale());
    }

    public List<Sale> getAllSalesByPaging(int index) {
        List<Sale> list = new ArrayList<>();
        try {
            String sql = "SELECT [SaleID]\n"
                    + "      ,[SaleValue]\n"
                    + "      ,[StartDate]\n"
                    + "      ,[EndDate]\n"
                    + "      ,[SaleName]\n"
                    + "      ,[SaleCode]\n"
                    + "  FROM [dbo].[Sale] Order by SaleID OFFSET ? ROWS FETCH FIRST 20 ROWS ONLY";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, (index - 1)*20);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Sale(rs.getInt(1), rs.getFloat(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception ex) {
            Logger.getLogger(SaleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
