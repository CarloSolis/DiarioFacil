/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

import java.util.List;

/**
 *
 * @author Cali
 */
public class ProductoTO {
    
    private ServicioProducto servicio = new ServicioProducto();
    
    public ProductoTO() {
    }
    
    public void insertar(Product product) throws Exception {
        servicio.insertar(product);
    }
    
    public void update(Product product) throws Exception {
        servicio.Update(product);
    }
    
    public void delete(Product product) throws Exception {
        servicio.Delete(product);
    }
    
     public Product buscaProducto(String nombre) throws Exception {
        servicio.buscaPorNombre(nombre);
    
     return new Product();
     }
    
    public List<Product> buscaTodos() throws Exception {
        return servicio.buscaTodos();
    }
}
