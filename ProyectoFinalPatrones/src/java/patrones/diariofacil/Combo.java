/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Cali
 */
@ManagedBean(name = "Combo", eager = true)
@RequestScoped

public class Combo {

    private String nombre;
    private ArrayList<Product> lstProducto = new ArrayList<>();

    public void insertCombo() {

        ServicioCombo SU = new ServicioCombo();
        Combo cb = new Combo();

        try {
            cb.setNombre(this.nombre);
            cb.setLstProducto(this.lstProducto);

            SU.insertar(cb);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

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
