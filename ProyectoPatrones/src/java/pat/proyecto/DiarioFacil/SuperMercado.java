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
public class SuperMercado {
    ArrayList<Provedor> providersList = new ArrayList<>();
    ArrayList<Cliente> clientsList = new ArrayList<>();
    ArrayList<Product> productsList = new ArrayList<>();
    //Admins uno o mas?
    private Administrador admin;

    public SuperMercado() {
    }

    

    public Administrador getAdmin() {
        return admin;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }
    
}