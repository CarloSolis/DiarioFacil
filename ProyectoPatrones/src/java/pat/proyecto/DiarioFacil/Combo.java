/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat.proyecto.DiarioFacil;

import java.util.ArrayList;

/**
 *
 * @author Cali
 */
public class Combo {
 
    private String nombre;
    private ArrayList<Product> lstProducto = new ArrayList<>(); 

    public Combo() {
    }

    public Combo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Product> getLstProducto() {
        return lstProducto;
    }

    public void setLstProducto(ArrayList<Product> lstProducto) {
        this.lstProducto = lstProducto;
    }
  
    
}