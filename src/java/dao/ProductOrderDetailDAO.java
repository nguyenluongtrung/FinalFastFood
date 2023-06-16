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
import model.ProductOrderDetail;

/**
 *
 * @author ADMIN
 */
public class ProductOrderDetailDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    
    public List<ProductOrderDetail> getAllProductOrderDetailByOrderID(int orderID){
        List<ProductOrderDetail> list = new ArrayList<>();
        try {
            String sql = "SELECT c.ProductID, c.[Name], c.AccumulatedPoint, c.Calories, d.Price, b.Quantity FROM [Order] a JOIN OrderDetail b ON a.OrderID = b.OrderID JOIN Product c ON b.ProductID = c.ProductID JOIN Price d ON d.ProductID = c.ProductID WHERE (a.OrderID = ?) AND d.EndDate is null";
            
            conn = new DBContext().getConnection();
            
            ps = conn.prepareStatement(sql);
            ps.setInt(1, orderID);
            
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new ProductOrderDetail(rs.getInt(1), rs.getString(2), rs.getInt(6), rs.getFloat(5), rs.getInt(4), rs.getInt(3)));
            }
        } catch (Exception ex) {
            Logger.getLogger(ProductOrderDetailDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println(new ProductOrderDetailDAO().getAllProductOrderDetailByOrderID(5));
    }
}
