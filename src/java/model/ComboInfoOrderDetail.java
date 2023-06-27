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
public class ComboInfoOrderDetail {
    private int comboID;
    private int quantity;
    private String comboName;
    private float totalPrice;
    private int totalCalories;
    private int accPoint;

    public ComboInfoOrderDetail() {
    }

    public ComboInfoOrderDetail(int comboID, int quantity, String comboName, float totalPrice, int totalCalories, int accPoint) {
        this.comboID = comboID;
        this.quantity = quantity;
        this.comboName = comboName;
        this.totalPrice = totalPrice;
        this.totalCalories = totalCalories;
        this.accPoint = accPoint;
    }

    public int getComboID() {
        return comboID;
    }

    public void setComboID(int comboID) {
        this.comboID = comboID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public int getAccPoint() {
        return accPoint;
    }

    public void setAccPoint(int accPoint) {
        this.accPoint = accPoint;
    }

    @Override
    public String toString() {
        return "ComboInfoOrderDetail{" + "comboID=" + comboID + ", quantity=" + quantity + ", comboName=" + comboName + ", totalPrice=" + totalPrice + ", totalCalories=" + totalCalories + ", accPoint=" + accPoint + '}';
    }
    
    
}
