/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jordan
 */
@ManagedBean(name = "nuevoUsuario", eager=true)
@ViewScoped

//hola
public class UsuarioNuevo {

    private int id;
    private String name;
    private int phone;
    private String email;
    private String password;
    private String tipo;
    private String lastName;
    private int idUser;
    private int numberOfPurchase;

    public void insertarUsuario() {

      ServicioUsuario SU = new ServicioUsuario();
        Usuario cliente = new Cliente();
        
        try {
            cliente.setName(this.name);
            cliente.setEmail(this.email);
            cliente.setPassword(this.password);
            cliente.setPhone(this.phone);
            cliente.setTipo(this.tipo);            
            ((Cliente) cliente).setLastName(lastName);
            ((Cliente) cliente).setNumberOfPurchase(numberOfPurchase);
            ((Cliente) cliente).setIdUser(idUser);
            
            SU.insertar((Cliente) cliente);
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getNumberOfPurchase() {
        return numberOfPurchase;
    }

    public void setNumberOfPurchase(int numberOfPurchase) {
        this.numberOfPurchase = numberOfPurchase;
    }
    

}
