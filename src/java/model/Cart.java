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
    
    public float getPriceByDate(int productID) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        Date cDate = new Date();
        for(Item i : items){
            if(i.getProduct().getProductID() == productID){
                Date sDate = sdf.parse(i.getProduct().getStartDate());
                int result1 = sDate.compareTo(cDate);
                if(result1 <= 0 && i.getProduct().getEndDate() == null){
                    return i.getProduct().getPrice();
                }
            }
        }
        return 0;
    }
    
    public float getTotalMoney(List<SaleProduct> list, Sale sale) throws ParseException{
        float sum = 0;
        float saleAmount = 0;
        if(sale != null){
            saleAmount = sale.getSaleValue();
        }
        for(Item item : items){
            int ok = 0;
            for(SaleProduct saleItem : list){
                if(item.getProduct().getProductID() == saleItem.getProductID()){
                    ok = 1;
                    if(item.getQuantity() > saleItem.getSaleQuantity()){
                        sum += 1.0 * saleItem.getSaleQuantity()*getPriceByDate(item.getProduct().getProductID())*(1- saleAmount) + (item.getQuantity() - saleItem.getSaleQuantity())*getPriceByDate(item.getProduct().getProductID());
                    }
                    else {
                        sum += 1.0 * item.getQuantity()*getPriceByDate(item.getProduct().getProductID())*(1- saleAmount);
                    }
                }
            }
            if(ok == 0){
                sum += item.getQuantity()*getPriceByDate(item.getProduct().getProductID());
            }
        }
        return sum;
    }
    
    public int getTotalAccumulatedPoints(){
        int sum = 0;
        for(Item item : items){
            sum += item.getProduct().getAccumulatedPoint()*item.getQuantity();
        }
        return sum;
    }

    public float getTotalMoney() throws ParseException{
        float sum = 0;
        for(Item item : items){
            sum += 1.0*item.getQuantity()*getPriceByDate(item.getProduct().getProductID());
        }
        return sum;
    }
    
    
    
}
