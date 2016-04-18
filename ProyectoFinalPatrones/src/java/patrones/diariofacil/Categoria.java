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
    private int id; 

    public Categoria(String nombreCategoria, int id) {
        this.nombreCategoria = nombreCategoria;
        this.id = id;
    }

    public Categoria() {
    }
    
    
    
    @Override
    public Product Crearproducto() {
        return new Product();
    }
    
  
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
}
