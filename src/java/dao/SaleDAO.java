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

}
