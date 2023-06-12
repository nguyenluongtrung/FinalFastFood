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
public class StatisticalProduct {
    private int productID;
    private String name;
    private int totalQuantity;

    public StatisticalProduct() {
    }

    public StatisticalProduct(int productID, String name, int totalQuantity) {
        this.productID = productID;
        this.name = name;
        this.totalQuantity = totalQuantity;
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

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    @Override
    public String toString() {
        return "StatisticalProduct{" + "productID=" + productID + ", name=" + name + ", totalQuantity=" + totalQuantity + '}';
    }

    
    
    
}
