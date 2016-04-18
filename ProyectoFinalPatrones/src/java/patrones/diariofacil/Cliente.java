/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Cali
 */
@ManagedBean(name = "Cliente", eager = true)
@RequestScoped

public class Cliente extends Usuario {

    private String LastName;
    private ArrayList<Orden> purchaseLst = new ArrayList<>();

    private int numberOfPurchase;
    private int idUser;
     private int numId;

    public int getNumId() {
        return numId;
    }

    public void setNumId(int numId) {
        this.numId = numId;
    }

   

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

    public void insertarCliente() {

        ServicioUsuario SU = new ServicioUsuario();
        Usuario user = new Usuario();

        try {
            user.setName(this.name);
            user.setEmail(this.email);
            user.setPassword(this.password);
            user.setPhone(this.phone);
            user.setTipo("Cliente");

            SU.insertar(user);
            idUser = idUsuario();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {
            user = new Cliente();
            ((Cliente) user).setLastName(LastName);
            ((Cliente) user).setNumberOfPurchase(numberOfPurchase);
            ((Cliente) user).setIdUser(idUser);
            SU.insertarCliente(((Cliente) user));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void actualizarCliente() {

        ServicioUsuario SU = new ServicioUsuario();
        Usuario user = new Usuario();
        Usuario cliente = new Cliente();
        
        try {

            user.setName(this.name);
            user.setPassword(this.password);
            user.setTipo("Cliente");
            user.setPhone(this.phone);
            user.setId(getNumId());
            SU.Update(user);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            ((Cliente) cliente).setLastName(this.LastName);
            ((Cliente) cliente).setIdUser(getNumId());
            SU.UpdateCliente(((Cliente) cliente));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public String tipoUsuario() {

        ServicioUsuario SU = new ServicioUsuario();
        Usuario User = new Usuario();

        try {
            for (Usuario usuario : SU.buscaTodos()) {
                if (usuario.getEmail().equals(this.email) && usuario.getPassword().equals(this.password)) {
                    tipo = usuario.getTipo();
                    System.out.println(tipo);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tipo;
    }

    public String validarUsuario() {

        String pag = "";
        numId= idUsuario();
        
        switch (tipoUsuario()) {
            case "Cliente":
                pag = "UserHome";
                break;
            case "Administrador":
                pag = "AdmiHome";
                break;
            default:
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usuario o contraseña incorrecto ", ""));
                pag = "Login";
                break;
        }
        return pag;
    }

    public Cliente() {
    }

    public Cliente(String LastName, int numberOfPurchase, int idUser) {
        this.LastName = LastName;

        this.numberOfPurchase = numberOfPurchase;
        this.idUser = idUser;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public ArrayList<Orden> getPurchaseLst() {
        return purchaseLst;
    }

    public void setPurchaseLst(ArrayList<Orden> purchaseLst) {
        this.purchaseLst = purchaseLst;
    }

    public int getNumberOfPurchase() {
        return numberOfPurchase;
    }

    public void setNumberOfPurchase(int numberOfPurchase) {
        this.numberOfPurchase = numberOfPurchase;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

}
