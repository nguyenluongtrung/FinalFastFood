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
public class ProductOrderDetail {
    private String productName;
    private int productQuantity;
    private float productPrice;
    private int calories;
    private int accumulatedPoints;

    public ProductOrderDetail() {
    }

    public ProductOrderDetail(String productName, int productQuantity, float productPrice, int calories, int accumulatedPoints) {
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
        this.calories = calories;
        this.accumulatedPoints = accumulatedPoints;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getAccumulatedPoints() {
        return accumulatedPoints;
    }

    public void setAccumulatedPoints(int accumulatedPoints) {
        this.accumulatedPoints = accumulatedPoints;
    }

    @Override
    public String toString() {
        return "ProductOrderDetail{" + "productName=" + productName + ", productQuantity=" + productQuantity + ", productPrice=" + productPrice + ", calories=" + calories + ", accumulatedPoints=" + accumulatedPoints + '}';
    }
    
    
}
