/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat.proyecto.DiarioFacil;

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
    
    public List<Product> buscaTodos() throws Exception {
        return servicio.buscaTodos();
    }
}
