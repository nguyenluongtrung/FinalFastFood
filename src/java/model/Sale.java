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
public class Sale {
    private int saleID;
    private String saleName;
    private float saleValue;
    private String startDate;
    private String endDate;
    private String saleCode;

    public Sale() {
    }

    public Sale(int saleID, float saleValue, String startDate, String endDate, String saleName, String saleCode) {
        this.saleID = saleID;
        this.saleName = saleName;
        this.saleValue = saleValue;
        this.startDate = startDate;
        this.endDate = endDate;
        this.saleCode = saleCode;
    }

    public int getSaleID() {
        return saleID;
    }

    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    public String getSaleName() {
        return saleName;
    }

    public void setSaleName(String saleName) {
        this.saleName = saleName;
    }

    public float getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(float saleValue) {
        this.saleValue = saleValue;
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

    public String getSaleCode() {
        return saleCode;
    }

    public void setSaleCode(String saleCode) {
        this.saleCode = saleCode;
    }

    @Override
    public String toString() {
        return "Sale{" + "saleID=" + saleID + ", saleName=" + saleName + ", saleValue=" + saleValue + ", startDate=" + startDate + ", endDate=" + endDate + ", saleCode=" + saleCode + '}';
    }
    
    
}
