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
public class Shipping {
    private int shippingID;
    private String name;
    private String address;
    private String phone;
    private String email;
    

    public Shipping() {
    }

    public Shipping(int shippingID, String name, String address, String phone, String email) {
        this.shippingID = shippingID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public int getShippingID() {
        return shippingID;
    }

    public void setShippingID(int shippingID) {
        this.shippingID = shippingID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Shipping{" + "shippingID=" + shippingID + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + '}';
    }

    

    
    
}
