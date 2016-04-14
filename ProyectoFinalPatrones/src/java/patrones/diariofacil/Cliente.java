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
@ManagedBean(name = "Cliente", eager = true)
@RequestScoped

public class Cliente extends Usuario{

    private String LastName;
    private ArrayList<Orden> purchaseLst = new ArrayList<>();
    private Boolean frequent;
    private String gender;
    private int numberOfPurchase;
    private int idUser;
    
    public void insertarUsuario() {

      ServicioUsuario SU = new ServicioUsuario();
        Usuario cliente = new Cliente();
        
        try {
            cliente.setName(this.name);
            cliente.setEmail(this.email);
            cliente.setPassword(this.password);
            cliente.setPhone(this.phone);
            cliente.setTipo(this.tipo);            
            ((Cliente) cliente).setFrequent(frequent);//para que? se puede quitar
            ((Cliente) cliente).setLastName(LastName);
            ((Cliente) cliente).setNumberOfPurchase(numberOfPurchase);
            ((Cliente) cliente).setIdUser(idUser);
            
            SU.insertar((Cliente) cliente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public Cliente() {
    }

    public Cliente(String LastName, int numberOfPurchase, int idUser, int id, String name, String email, String password, String tipo, int phone) {
        super(id, name, email, password, tipo, phone);
        this.LastName = LastName;
        this.numberOfPurchase = numberOfPurchase;
        this.idUser = idUser;
    }

    public Cliente(String LastName, Boolean frequent, String gender, int numberOfPurchase) {

        this.LastName = LastName;
        this.frequent = frequent;
        this.gender = gender;
        this.numberOfPurchase = numberOfPurchase;
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

    public Boolean getFrequent() {
        return frequent;
    }

    public void setFrequent(Boolean frequent) {
        this.frequent = frequent;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
