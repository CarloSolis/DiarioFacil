/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "Carro", eager = true)
@RequestScoped
/**
 *
 * @author Cali
 */
public class Carro {

    Cliente client;
    ArrayList<Item> itemList = new ArrayList<>();
    double total = 0;

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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    public void addItem(Item item) {
        this.itemList.add(item);

    }

    public double total() {
        for (Item i : this.itemList) {
            total= i.FinalTotal();
        }
        return total;
    }

}
