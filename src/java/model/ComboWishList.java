/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ComboWishList {
    private List<Combo> combos;

    public ComboWishList() {
        combos = new ArrayList<>();
    }

    public List<Combo> getCombos() {
        return combos;
    }

    public void setCombos(List<Combo> combos) {
        this.combos = combos;
    }

    public Combo getComboByID(int id) {
        for (Combo combo : combos) {
            if (combo.getComboID() == id) {
                return combo;
            }
        }
        return null;
    }

    public void removeProduct(int id) {
        Combo combo = getComboByID(id);
        if (combo != null) {
            combos.remove(combo);
        }
    }

    public void addComboToWishList(Combo combo) {
        if (getComboByID(combo.getComboID()) != null) {
            return;
        } else {
            combos.add(combo);
        }
    }

    public static void main(String[] args) {
    }
}
