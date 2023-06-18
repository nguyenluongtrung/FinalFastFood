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
public class Combo {
    private int comboID;
    private String comboName;
    private String image;
    private int totalCalories;
    private float totalPrice;
    private float rating;
    private int accumulatedPoint;
    private int exchangedPoint;

    public Combo() {
    }

    public Combo(int comboID, String comboName, String image, int totalCalories, float totalPrice, float rating, int accumulatedPoint, int exchangedPoint) {
        this.comboID = comboID;
        this.comboName = comboName;
        this.image = image;
        this.totalCalories = totalCalories;
        this.totalPrice = totalPrice;
        this.rating = rating;
        this.accumulatedPoint = accumulatedPoint;
        this.exchangedPoint = exchangedPoint;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        return "Combo{" + "comboID=" + comboID + ", comboName=" + comboName + ", image=" + image + ", totalCalories=" + totalCalories + ", totalPrice=" + totalPrice + ", rating=" + rating + ", accumulatedPoint=" + accumulatedPoint + ", exchangedPoint=" + exchangedPoint + '}';
    }
    
    
}
