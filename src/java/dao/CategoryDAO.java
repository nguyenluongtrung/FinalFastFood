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
import model.Category;

/**
 *
 * @author ADMIN
 */
public class CategoryDAO {
    
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public Category getCategoryByID(int id) {
        try {
            String sql = "SELECT [CategoryID]\n"
                    + "      ,[CategoryName]\n"
                    + "  FROM [dbo].[Category]\n"
                    + "  WHERE CategoryID = ?";
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                return new Category(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Category> getAllCategory() {
        List<Category> list = new ArrayList<>();
        try {
            String sql = "SELECT [CategoryID]\n"
                    + "      ,[CategoryName]\n"
                    + "  FROM [dbo].[Category]";
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public List<Category> getCategoryByChoices(int choice) {
        List<Category> list = new ArrayList<>();
        try {
            String sql = "";
            if (choice == 1) {
                sql = "SELECT [CategoryID]\n"
                        + "      ,[CategoryName]\n"
                        + "  FROM [dbo].[Category]\n"
                        + "  WHERE CategoryID in (1,3,5,7)";
            } else if (choice == 2) {
                sql = "SELECT [CategoryID]\n"
                        + "      ,[CategoryName]\n"
                        + "  FROM [dbo].[Category]\n"
                        + "  WHERE CategoryID in (2,6,8)";
            } else {
                sql = "SELECT [CategoryID]\n"
                        + "      ,[CategoryName]\n"
                        + "  FROM [dbo].[Category]\n"
                        + "  WHERE CategoryID in (4)";
            }
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Category(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println(new CategoryDAO().getCategoryByChoices(3));
    }
    
}
