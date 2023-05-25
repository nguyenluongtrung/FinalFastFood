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
public class Product {
    private int productID;
    private String name;
    private String image;
    private int categoryID;
    private int quantity;
    private int calories;
    private boolean isSurprise;
    private float rating;
    private int accumulatedPoint;
    private int exchangedPoint;

    public Product() {
    }

    public Product(int productID, String name, String image, int categoryID, int quantity, int calories, boolean isSurprise, float rating, int accumulatedPoint, int exchangedPoint) {
        this.productID = productID;
        this.name = name;
        this.image = image;
        this.categoryID = categoryID;
        this.quantity = quantity;
        this.calories = calories;
        this.isSurprise = isSurprise;
        this.rating = rating;
        this.accumulatedPoint = accumulatedPoint;
        this.exchangedPoint = exchangedPoint;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean isIsSurprise() {
        return isSurprise;
    }

    public void setIsSurprise(boolean isSurprise) {
        this.isSurprise = isSurprise;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getAccumulatedPoint() {
        return accumulatedPoint;
    }

    public void setAccumulatedPoint(int accumulatedPoint) {
        this.accumulatedPoint = accumulatedPoint;
    }

    public int getExchangedPoint() {
        return exchangedPoint;
    }

    public void setExchangedPoint(int exchangedPoint) {
        this.exchangedPoint = exchangedPoint;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", name=" + name + ", image=" + image + ", categoryID=" + categoryID + ", quantity=" + quantity + ", calories=" + calories + ", isSurprise=" + isSurprise + ", rating=" + rating + ", accumulatedPoint=" + accumulatedPoint + ", exchangedPoint=" + exchangedPoint + '}';
    }
    
    
    
}
