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
public class ComboProduct {
    private int comboID;
    private int productID;
    private int productQuantity;

    public ComboProduct() {
    }

    public ComboProduct(int comboID, int productID, int productQuantity) {
        this.comboID = comboID;
        this.productID = productID;
        this.productQuantity = productQuantity;
    }

    public int getComboID() {
        return comboID;
    }

    public void setComboID(int comboID) {
        this.comboID = comboID;
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

    @Override
    public String toString() {
        return "ComboProduct{" + "comboID=" + comboID + ", productID=" + productID + ", productQuantity=" + productQuantity + '}';
    }
    
    
}
