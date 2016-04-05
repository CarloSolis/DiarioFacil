/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat.proyecto.DiarioFacil;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Carro {

    Cliente client;
    ArrayList<Item> itemList = new ArrayList<>();
    int total = 0;
    double totalWODiscount;

    public Carro() {
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public void setItemList(ArrayList<Item> itemList) {
        this.itemList = itemList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getTotalWODiscount() {
        return totalWODiscount;
    }

    public void setTotalWODiscount(double totalWODiscount) {
        this.totalWODiscount = totalWODiscount;
    }
    
     public void addItem(Item item) {
        this.itemList.add(item);

    }
    

    public double total() {
        for (Item i : this.itemList) {
            totalWODiscount = totalWODiscount + i.FinalTotal();
        }
        return totalWODiscount;
    }

   
}
