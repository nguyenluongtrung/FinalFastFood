/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class Product {
    private int productID;
    private String name;
    private String image;
    private int categoryID;
    private int calories;
    private boolean isSurprise;
    private float rating;
    private int accumulatedPoint;
    private int exchangedPoint;
    private int priceID;
    private String startDate;
    private String endDate;
    private float price;
    private boolean status;
    private String p_startDate;
    private String p_endDate;

    public Product() {
    }

    public Product(int priceID, String startDate, String endDate, float price, int productID, String name, String image, int categoryID, int calories, boolean isSurprise, float rating, int accumulatedPoint, int exchangedPoint, boolean status, String p_startDate, String p_endDate) {
        this.productID = productID;
        this.name = name;
        this.image = image;
        this.categoryID = categoryID;
        this.calories = calories;
        this.isSurprise = isSurprise;
        this.rating = rating;
        this.accumulatedPoint = accumulatedPoint;
        this.exchangedPoint = exchangedPoint;
        this.priceID = priceID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.status = status;
        this.p_startDate = p_startDate;
        this.p_endDate = p_endDate;
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

    public int getPriceID() {
        return priceID;
    }

    public void setPriceID(int priceID) {
        this.priceID = priceID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getP_startDate() {
        return p_startDate;
    }

    public void setP_startDate(String p_startDate) {
        this.p_startDate = p_startDate;
    }

    public String getP_endDate() {
        return p_endDate;
    }

    public void setP_endDate(String p_endDate) {
        this.p_endDate = p_endDate;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", name=" + name + ", image=" + image + ", categoryID=" + categoryID + ", calories=" + calories + ", isSurprise=" + isSurprise + ", rating=" + rating + ", accumulatedPoint=" + accumulatedPoint + ", exchangedPoint=" + exchangedPoint + ", priceID=" + priceID + ", startDate=" + startDate + ", endDate=" + endDate + ", price=" + price + ", status=" + status + ", p_startDate=" + p_startDate + ", p_endDate=" + p_endDate + '}';
    }

    

}
