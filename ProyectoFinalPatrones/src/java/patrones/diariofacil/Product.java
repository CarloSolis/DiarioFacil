/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Cali
 */
@ManagedBean(name = "Product", eager = true)
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
    private int idProvider;
    private int idCategory;
    
      public Product() {
    }
    
    

    public Product(String name, int price, int actualStock) {
        this.name = name;
        this.price = price;
        this.actualStock = actualStock;
    }


    public Product(int id, String name, String description, int price, int minimunStock, int actualStock, int idProvider, int idCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.minimunStock = minimunStock;
        this.actualStock = actualStock;
        this.idProvider = idProvider;
        this.idCategory = idCategory;
    }
        
    public Product( String name, int actualStock) {
      
        this.name = name;
        this.actualStock = actualStock;
    }

            
    @Override
    public void insertProduct() {
        Caretaker ct = new Caretaker();
        ServicioProducto SP = new ServicioProducto();
        Product p = new Product();

        try {
            p.setName(this.name);
            p.setDescription(this.description);
            p.setPrice(this.price);
            p.setActualStock(actualStock);
            p.setMinimunStock(this.minimunStock);
            p.setIdProvider(this.idProvider);
            p.setIdCategory(this.idCategory);

            SP.insertar(p);
            ct.addMemento(p.saveToMemento());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

   

    @Override
    public List<Product> getAllProducts() throws Exception {
        ServicioProducto SP = new ServicioProducto();
        List<Product> lstProduct = new ArrayList<Product>();
        
         try {

            for (Product prod : SP.buscaTodos()) {
                  lstProduct.add(new Product(prod.getName(),prod.getPrice(),prod.getActualStock()));            
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
       
        return lstProduct;
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

    public int getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
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
        return   "Producto : " + name +  " Precio : " + price + " Cantidad disponible : "+actualStock;
    }

}
