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
   
    private int numberOfPurchase;
    private int idUser;
    
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
