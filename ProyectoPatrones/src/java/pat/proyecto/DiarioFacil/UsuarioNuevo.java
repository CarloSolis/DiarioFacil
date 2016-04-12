/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat.proyecto.DiarioFacil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jordan
 */
@ManagedBean(name = "nuevoUsuario")
@ViewScoped

public class UsuarioNuevo {

    private int id;
    private String name;
    private int phone;
    private String email;
    private String password;
    private String tipo;

    public void insertarUsuario() {

        ServicioUsuario SU = new ServicioUsuario();
        Usuario cliente = new Cliente();

        try {
            cliente.setName(this.name);
            cliente.setEmail(this.email);
            cliente.setPassword(this.password);
            cliente.setPhone(this.phone);
            cliente.setTipo(this.tipo);
            SU.insertar(cliente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    
}
