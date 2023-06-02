/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class WishList {

    private List<Product> products;

    public WishList() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Product getProductByID(int id) {
        for (Product pro : products) {
            if (pro.getProductID() == id) {
                return pro;
            }
        }
        return null;
    }

    public void removeProduct(int id) {
        Product pro = getProductByID(id);
        if (pro != null) {
            products.remove(pro);
        }
    }

    public void addProductToWishList(Product pro) {
        if (getProductByID(pro.getProductID()) != null) {
            return;
        } else {
            products.add(pro);
        }
    }

    public static void main(String[] args) {
        WishList wl = new WishList();
        System.out.println(wl.getProductByID(0));
    }
}

