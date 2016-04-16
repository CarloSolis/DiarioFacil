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
@ManagedBean(name = "nuevoUsuario", eager = true)
@ViewScoped


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
    private String cedulaJuridica;
   
    
    public int idUsuario() {

        ServicioUsuario SU = new ServicioUsuario();
        Usuario User = new Usuario();

        try {
            for (Usuario usuario : SU.buscaTodos()) {
                if (usuario.getEmail().equals(this.email)) {
                    id = usuario.getId();
                     System.out.println(id);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public void insertarUsuario() {

        ServicioUsuario SU = new ServicioUsuario();
        Usuario user = new Usuario();
        
        try {
            user.setName(this.name);
            user.setEmail(this.email);
            user.setPassword(this.password);
            user.setPhone(this.phone);
            user.setTipo(this.tipo);

            SU.insertar(user);
            idUser = idUsuario();
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if(tipo.equals("Cliente")){
        try {
             user = new Cliente();
            ((Cliente) user).setLastName(lastName);
            ((Cliente) user).setNumberOfPurchase(numberOfPurchase);
            ((Cliente) user).setIdUser(idUser);
              SU.insertarCliente(((Cliente) user));
        } catch (Exception ex) {
            ex.printStackTrace();
        }}
        
        else if(tipo.equals("Proveedor")){
        try {
             user = new Provedor();
            ((Provedor) user).setCedulaJuridica(cedulaJuridica);
            ((Provedor) user).setIdUser(idUser);
              SU.insertarProveedor(((Provedor) user));
        } catch (Exception ex) {
            ex.printStackTrace();
        }}
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
