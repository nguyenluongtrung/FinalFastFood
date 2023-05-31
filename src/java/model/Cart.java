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
public class Cart {
    private List<Item> items;

    public Cart(List<Item> items) {
        this.items = items;
    }

    public Cart() {
        items = new ArrayList<>();
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getItemByID(int id){
        for(Item item : items){
            if(item.getProduct().getProductID() == id){
                return item;
            }
        }
        return null;
    }
    
    public void addItemToCart(Item item){
        if(getItemByID(item.getProduct().getProductID()) != null){
            Item oldItem = getItemByID(item.getProduct().getProductID());
            oldItem.setQuantity(oldItem.getQuantity() + item.getQuantity());
        }
        else{
            items.add(item);
        }
    }
    
    public void removeItem(int id){
        Item item = getItemByID(id);
        if(item != null){
            items.remove(item);
        }
    }
    
    public int getPriceByDate(int productID) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Date cDate = new Date();
        for(Item i : items){
            if(i.getProduct().getProductID() == productID){
                Date sDate = sdf.parse(i.getProduct().getStartDate());
                Date eDate = sdf.parse(i.getProduct().getEndDate());
                int result1 = sDate.compareTo(cDate);
                int result2 = cDate.compareTo(eDate);
                if(result1 <= 0 && result2 <= 0){
                    return i.getProduct().getPrice();
                }
            }
        }
        return 0;
    }
    
    public int getTotalMoney() throws ParseException{
        int sum = 0;
        for(Item item : items){
            sum += item.getQuantity()*getPriceByDate(item.getProduct().getProductID());
        }
        return sum;
    }
    
    
    
}
