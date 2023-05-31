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
public class Order {
    private int orderID;
    private int totalPrice;
    private int shippingID;
    private String note;
    private String status;
    private String date;
    private int accountID;

    public Order() {
    }

    public Order(int orderID, int totalPrice, int shippingID, String note, String status, String date, int accountID) {
        this.orderID = orderID;
        this.totalPrice = totalPrice;
        this.shippingID = shippingID;
        this.note = note;
        this.status = status;
        this.date = date;
        this.accountID = accountID;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getShippingID() {
        return shippingID;
    }

    public void setShippingID(int shippingID) {
        this.shippingID = shippingID;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", totalPrice=" + totalPrice + ", shippingID=" + shippingID + ", note=" + note + ", status=" + status + ", date=" + date + ", accountID=" + accountID + '}';
    }
    
    
}
