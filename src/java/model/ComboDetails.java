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
public class ComboDetails {
    private int comboID;
    private String comboName;
    private String comboImage;
    private int totalCalories;
    private float totalPrice;
    private float rating;
    private int accPoint;
    private int exPoint;
    private int productID;
    private int productQuantity;
    private String productName;
    private boolean productStatus;

    public ComboDetails() {
    }

    public ComboDetails(int comboID, String comboName, String comboImage, int totalCalories, float totalPrice, float rating, int accPoint, int exPoint, int productID, int productQuantity, String productName, boolean productStatus) {
        this.comboID = comboID;
        this.comboName = comboName;
        this.comboImage = comboImage;
        this.totalCalories = totalCalories;
        this.totalPrice = totalPrice;
        this.rating = rating;
        this.accPoint = accPoint;
        this.exPoint = exPoint;
        this.productID = productID;
        this.productQuantity = productQuantity;
        this.productName = productName;
        this.productStatus = productStatus;
    }

    public int getComboID() {
        return comboID;
    }

    public void setComboID(int comboID) {
        this.comboID = comboID;
    }

    public String getComboName() {
        return comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    public String getComboImage() {
        return comboImage;
    }

    public void setComboImage(String comboImage) {
        this.comboImage = comboImage;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getAccPoint() {
        return accPoint;
    }

    public void setAccPoint(int accPoint) {
        this.accPoint = accPoint;
    }

    public int getExPoint() {
        return exPoint;
    }

    public void setExPoint(int exPoint) {
        this.exPoint = exPoint;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        return "ComboDetails{" + "comboID=" + comboID + ", comboName=" + comboName + ", comboImage=" + comboImage + ", totalCalories=" + totalCalories + ", totalPrice=" + totalPrice + ", rating=" + rating + ", accPoint=" + accPoint + ", exPoint=" + exPoint + ", productID=" + productID + ", productQuantity=" + productQuantity + ", productName=" + productName + ", productStatus=" + productStatus + '}';
    }
    
    
}
