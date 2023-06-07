/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
import model.FeedBack;
import model.FeedbackAccount;

/**
 *
 * @author PC
 */
public class FeedbackDAO {

    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    public void addNewFeedback(FeedBack feedback) {
        try {
            String sql = "INSERT INTO [dbo].[Review]\n"
                    + "           ([Msg]\n"
                    + "           ,[Reply]\n"
                    + "           ,[Date]\n"
                    + "           ,[UserID]\n"
                    + "           ,[ProductID])\n"
                    + "     VALUES\n"
                    + "           (?,?,GETDATE(),?,?)";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, feedback.getMsg());
            ps.setString(2, feedback.getReply());
            ps.setInt(3, feedback.getUserID());
            ps.setInt(4, feedback.getProductID());

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<FeedbackAccount> getAllFeedback() {
        List<FeedbackAccount> list = new ArrayList<>();
        try {
            String sql = "SELECT Review.ReviewID, Review.UserID, Review.Msg, Review.Reply,"
                    + " Review.Date, Review.ProductID,\n"
                    + "Account.Gender, Account.Name FROM Review "
                    + "INNER JOIN Account ON Review.UserID=Account.AccountID";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FeedbackAccount(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7), rs.getString(8)));
            }
        } catch (Exception ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<FeedbackAccount> getFeedbackByProductID(int productID) {
        List<FeedbackAccount> list = new ArrayList<>();
        try {
            String sql = "SELECT Review.ReviewID, Review.UserID, Review.Msg, Review.Reply, Review.Date, "
                    + "Review.ProductID,Account.Gender, Account.Name FROM Review "
                    + "INNER JOIN Account ON Review.UserID=Account.AccountID where ProductID=?";
            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, productID);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FeedbackAccount(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getBoolean(7), rs.getString(8)));
            }
        } catch (Exception ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new FeedbackDAO().getFeedbackByProductID(1));
    }

    public int countFeedBack(int productID) {
        try {
            String sql = "SELECT COUNT(*)\n"
                    + "  FROM Review\n"
                    + "  WHERE productID=?";
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, productID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public void replyFeedbackByID(int feedbackID, String reply) {
        try {
            String sql = "UPDATE [dbo].[Review] SET [Reply] = ? WHERE [ReviewID] = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setString(1, reply);
            ps.setInt(2, feedbackID);

            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<FeedBack> getFeedbacksByAccountID(int accountID) {
        List<FeedBack> list = new ArrayList<>();
        try {
            String sql = "SELECT [ReviewID]\n"
                    + "      ,[Msg]\n"
                    + "      ,[Reply]\n"
                    + "      ,[Date]\n"
                    + "      ,[UserID]\n"
                    + "      ,[ProductID]\n"
                    + "  FROM [dbo].[Review]\n"
                    + "  WHERE UserID = ?";

            conn = new DBContext().getConnection();

            ps = conn.prepareStatement(sql);
            ps.setInt(1, accountID);

            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FeedBack(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6)));
            }
        } catch (Exception ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

}
