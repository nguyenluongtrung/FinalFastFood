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
public class ComboItem {
    private Combo combo;
    private int quantity;

    public ComboItem() {
    }

    public ComboItem(Combo combo, int quantity) {
        this.combo = combo;
        this.quantity = quantity;
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ComboItem{" + "combo=" + combo + ", quantity=" + quantity + '}';
    }

    
    
    
}
