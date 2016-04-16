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
public class Categoria implements ICatalogo{
 
    private String nombreCategoria;
        
    @Override
    public Product Crearproducto() {
        return new Product();
    }

    
    
}
