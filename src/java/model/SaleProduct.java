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
public class SaleProduct {
    private int saleID;
    private int productID;
    private int saleQuantity;

    public SaleProduct() {
    }

    public SaleProduct(int saleID, int productID, int saleQuantity) {
        this.saleID = saleID;
        this.productID = productID;
        this.saleQuantity = saleQuantity;
    }

    public int getSaleID() {
        return saleID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getSaleQuantity() {
        return saleQuantity;
    }

    public void setSaleQuantity(int saleQuantity) {
        this.saleQuantity = saleQuantity;
    }

    @Override
    public String toString() {
        return "SaleProduct{" + "saleID=" + saleID + ", productID=" + productID + ", saleQuantity=" + saleQuantity + '}';
    }
    
    
}
