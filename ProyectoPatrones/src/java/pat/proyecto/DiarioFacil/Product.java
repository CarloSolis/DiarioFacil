/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat.proyecto.DiarioFacil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Cali
 */
@ManagedBean(name = "Producto", eager = true)
@RequestScoped

public class Product implements IProducto{

    private int id;
    private String name;
    private String description;
    private int price;
    private Provedor provider;
    private int minimunStock;
    private int actualStock;

    public Product() {
    }

    public Product(int id, String name, String description,  int price, Provedor provider, int minimunStock, int actualStock) {
        this.id = id;
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
    
    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + '}';
    }

}
