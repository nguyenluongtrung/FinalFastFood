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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class AccountDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public Account login(String email, String pass) {
        String query = "SELECT * FROM Account where Email=? and Password=?";

        try {
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(query);

            ps.setString(1, email);
            ps.setString(2, pass);

            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9), rs.getInt(10), rs.getString(11));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void create(Account account) {
        try {
            String sql = "INSERT INTO [dbo].[Account]\n"
                    + "           ([Role]\n"
                    + "           ,[Name]\n"
                    + "           ,[Address]\n"
                    + "           ,[Phone]\n"
                    + "           ,[Email]\n"
                    + "           ,[Dob]\n"
                    + "           ,[Gender]\n"
                    + "           ,[TotalAccumulatedPoint]\n"
                    + "           ,[Password])\n"
                    + "     VALUES (?,?,?,?,?,?,?,?,?)";

            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, account.getRole());
            ps.setString(2, account.getName());
            ps.setString(3, account.getAddress());
            ps.setString(4, account.getPhone());
            ps.setString(5, account.getEmail());
            ps.setString(6, account.getDob());
            ps.setBoolean(7, account.isGender());
            ps.setInt(8, 0);
            ps.setString(9, account.getPassword());

            ps.executeUpdate();
        } catch (Exception ex) {
        }
    }

    public boolean updateAccount(String name, String address, String phone, String dob, boolean gender, String password, int accountID) {
        boolean result = false;
        try {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "   SET\n"
                    + "       [Name] = ?\n"
                    + "      ,[Address] = ?\n"
                    + "      ,[Phone] = ?\n"
                    + "      ,[Dob] = ?\n"
                    + "      ,[Gender] = ?\n"
                    + "      ,[Password] = ?\n"
                    + " WHERE AccountID = ?";
            //mở connet đến SQL server
            conn = new DBContext().getConnection();

            //Câu lệnh cghauarn bị thực thi 
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phone);
            ps.setString(4, dob);
            ps.setBoolean(5, gender);
            ps.setString(6, password);
            ps.setInt(7, accountID);
            //Execute và return kết quả
            ps.executeUpdate();
            result = true;
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new AccountDAO().getAccountByID(4));
    }

    public Account getAccountByEmail(String email) {
        try {
            String sql = "SELECT [AccountID]\n"
                    + "      ,[Role]\n"
                    + "      ,[CreatedDate]\n"
                    + "      ,[Name]\n"
                    + "      ,[Address]\n"
                    + "      ,[Phone]\n"
                    + "      ,[Email]\n"
                    + "      ,[Dob]\n"
                    + "      ,[Gender]\n"
                    + "      ,[TotalAccumulatedPoint]\n"
                    + "      ,[Password]\n"
                    + "  FROM [dbo].[Account]\n"
                    + "  WHERE Email = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, email);

            rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9), rs.getInt(10), rs.getString(11));
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updatePassword(String password2, Account account) {
        try {
            String sql = "UPDATE [dbo].[Account]\n"
                    + "   SET [Password] = ?\n"
                    + " WHERE AccountID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, password2);
            ps.setInt(2, account.getAccountID());

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateAccumulatedPoints(int accountID, int totalAccumulatedPoints, int type) {
        try {
            String sql = "";
            if (type == 1) {
                sql = "UPDATE [dbo].[Account]\n"
                        + "   SET [TotalAccumulatedPoint] = [TotalAccumulatedPoint] + ?\n"
                        + " WHERE AccountID = ?";
            } else {
                sql = "UPDATE [dbo].[Account]\n"
                        + "   SET [TotalAccumulatedPoint] = ?\n"
                        + " WHERE AccountID = ?";
            }

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, totalAccumulatedPoints);
            ps.setInt(2, accountID);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Account getAccountByID(int id) {
        try {
            String sql = "SELECT [AccountID]\n"
                    + "      ,[Role]\n"
                    + "      ,[CreatedDate]\n"
                    + "      ,[Name]\n"
                    + "      ,[Address]\n"
                    + "      ,[Phone]\n"
                    + "      ,[Email]\n"
                    + "      ,[Dob]\n"
                    + "      ,[Gender]\n"
                    + "      ,[TotalAccumulatedPoint]\n"
                    + "      ,[Password]\n"
                    + "  FROM [dbo].[Account]\n"
                    + "  WHERE AccountID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                return new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getBoolean(9), rs.getInt(10), rs.getString(11));
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
