/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Cali
 */
@ManagedBean(name = "Producto", eager = true)
@RequestScoped

public class Product implements IProducto {

    private int id;
    private String name;
    private String description;
    private int price;
    private Provedor provider;
    private int minimunStock;
    private int actualStock;
    private Product product;

    public void insertProduct() {
        Caretaker ct = new Caretaker();
        ServicioProducto SU = new ServicioProducto();
        Product p = new Product();

        try {
            p.setName(this.name);
            p.setDescription(this.description);
            p.setPrice(this.price);
            p.setProvider(this.provider);
            p.setMinimunStock(this.minimunStock);
            SU.insertar(p);
            ct.addMemento(p.saveToMemento());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Product() {
    }

    public Product(String name, String description, int price, Provedor provider, int minimunStock, int actualStock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.provider = provider;
        this.minimunStock = minimunStock;
        this.actualStock = actualStock;
    }

    Product(int id, String nombre, String description, int price, int provider, int minimunStock, int actualStock) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Provedor getProvider() {
        return provider;
    }

    public void setProvider(Provedor provider) {
        this.provider = provider;
    }

    public int getMinimunStock() {
        return minimunStock;
    }

    public void setMinimunStock(int minimunStock) {
        this.minimunStock = minimunStock;
    }

    public int getActualStock() {
        return actualStock;
    }

    public void setActualStock(int actualStock) {
        this.actualStock = actualStock;
    }

    public Memento saveToMemento() {

        System.err.println("Guardando Memento....");
        return new Memento(product);
    }

    public void restoreFromMemento(Memento m) {
        product = m.getProducto();
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + '}';
    }

}
