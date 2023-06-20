/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author ADMIN
 */
public class ComboOrderDetail {
    private int comboID;
    private int orderID;
    private int quantity;

    public ComboOrderDetail() {
    }

    public ComboOrderDetail(int comboID, int orderID, int quantity) {
        this.comboID = comboID;
        this.orderID = orderID;
        this.quantity = quantity;
    }

    public int getComboID() {
        return comboID;
    }

    public void setComboID(int comboID) {
        this.comboID = comboID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ComboOrderDetail{" + "comboID=" + comboID + ", orderID=" + orderID + ", quantity=" + quantity + '}';
    }
    
    
}
