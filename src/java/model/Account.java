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
public class Account {
    private int accountID;
    private String role;
    private String createdDate;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String dob;
    private boolean gender;
    private int totalAccumulatedPoint;
    private String password;

    public Account() {
    }

    public Account(int accountID, String role, String createdDate, String name, String address, String phone, String email, String dob, boolean gender, int totalAccumulatedPoint, String password) {
        this.accountID = accountID;
        this.role = role;
        this.createdDate = createdDate;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.totalAccumulatedPoint = totalAccumulatedPoint;
        this.password = password;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getTotalAccumulatedPoint() {
        return totalAccumulatedPoint;
    }

    public void setTotalAccumulatedPoint(int totalAccumulatedPoint) {
        this.totalAccumulatedPoint = totalAccumulatedPoint;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" + "accountID=" + accountID + ", role=" + role + ", createdDate=" + createdDate + ", name=" + name + ", address=" + address + ", phone=" + phone + ", email=" + email + ", dob=" + dob + ", gender=" + gender + ", totalAccumulatedPoint=" + totalAccumulatedPoint + ", password=" + password + '}';
    }
    
    
}
