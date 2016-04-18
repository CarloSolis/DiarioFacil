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

@ManagedBean(name = "Categoria", eager = true)
@RequestScoped

public class Categoria implements ICatalogo{
 
    private String nombreCategoria;
    private int id; 

    
    public Categoria(String nombreCategoria, int id) {
        this.nombreCategoria = nombreCategoria;
        this.id = id;
    }

    public Categoria() {
    }

    public Categoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    
    
    public void insertarCategoria() {

        ServicioCategoria SC = new ServicioCategoria();
        Categoria categoria = new Categoria();

        try {
            categoria.setNombreCategoria(this.nombreCategoria);
            
            SC.insertarCategoria(categoria);
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    
    }
    public List<Categoria> allCatagories() {

        List<Categoria> listaCategorias = new ArrayList<Categoria>();
        ServicioCategoria SC = new ServicioCategoria();

        try {

            for (Categoria categoria : SC.buscaTodos()) {
                listaCategorias.add(new Categoria(categoria.getNombreCategoria(),categoria.getId()));
                
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        System.out.println(listaCategorias);
        return listaCategorias;
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

       @Override
            public String toString() {
    
                return nombreCategoria +" "+ id;
}
    
}
