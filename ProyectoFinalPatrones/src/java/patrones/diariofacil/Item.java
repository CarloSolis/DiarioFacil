/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

/**
 *
 * @author Cali
 */
public class Item {

    private Product product;
    private int quantity;
    private int lineNumber;
    private int total;
    private double price;
    //private Combo combo;

    public Item() {
    }

    public Item(Product product, int quantity, int lineNumber) {
        this.product = product;
        this.quantity = quantity;
        this.lineNumber = lineNumber;
     
    }

    
    

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public double FinalTotal() {
        total = product.getPrice() * quantity;
        return total;
    }
}
