/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ComboCart {
    private List<ComboItem> comboItems;

    public ComboCart(List<ComboItem> comboItems) {
        this.comboItems = comboItems;
    }

    public ComboCart() {
        comboItems = new ArrayList<>();
    }

    public List<ComboItem> getComboItems() {
        return comboItems;
    }

    public void setComboItems(List<ComboItem> comboItems) {
        this.comboItems = comboItems;
    }

    public ComboItem getComboItemByID(int id){
        for(ComboItem item : comboItems){
            if(item.getCombo().getComboID() == id){
                return item;
            }
        }
        return null;
    }
    
    public void addItemToCart(ComboItem item){
        if(getComboItemByID(item.getCombo().getComboID()) != null){
            ComboItem oldItem = getComboItemByID(item.getCombo().getComboID());
            oldItem.setQuantity(oldItem.getQuantity() + item.getQuantity());
        }
        else{
            comboItems.add(item);
        }
    }
    
    public void removeItem(int id){
        ComboItem item = getComboItemByID(id);
        if(item != null){
            comboItems.remove(item);
        }
    }
    
    public int getTotalAccumulatedPoints(){
        int sum = 0;
        for(ComboItem item : comboItems){
            sum += item.getCombo().getAccumulatedPoint()*item.getQuantity();
        }
        return sum;
    }

    public float getTotalMoney() throws ParseException{
        float sum = 0;
        for(ComboItem item : comboItems){
            sum += 1.0*item.getQuantity()*item.getCombo().getTotalPrice();
        }
        return sum;
    }
    
    
    
}
