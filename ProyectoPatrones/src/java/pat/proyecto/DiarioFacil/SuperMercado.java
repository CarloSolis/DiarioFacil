/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat.proyecto.DiarioFacil;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Cali
 */
@ManagedBean(name = "SuperMercado", eager = true)
@RequestScoped

public class SuperMercado {

    ArrayList<Provedor> providersList = new ArrayList<>();
    ArrayList<Cliente> clientsList = new ArrayList<>();
    ArrayList<Product> productsList = new ArrayList<>();
    //Admins uno o mas?
    private Administrador admin;
    private Categoria categoria;

    public SuperMercado(ICatalogo catalogo) {
    categoria.Crearproducto();
        
    }

    public SuperMercado() {
    }

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

}
