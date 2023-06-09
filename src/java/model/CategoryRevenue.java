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
public class CategoryRevenue {
    private int categoryID;
    private float totalPrice;
    private String categoryName;

    public CategoryRevenue() {
    }

    public CategoryRevenue(int categoryID, float totalPrice, String categoryName) {
        this.categoryID = categoryID;
        this.totalPrice = totalPrice;
        this.categoryName = categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryRevenue{" + "categoryID=" + categoryID + ", totalPrice=" + totalPrice + ", categoryName=" + categoryName + '}';
    }
    
    
}
