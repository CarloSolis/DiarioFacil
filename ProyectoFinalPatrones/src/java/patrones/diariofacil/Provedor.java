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
@ManagedBean(name = "Provedor", eager = true)
@RequestScoped

public class Provedor extends Usuario {

    private ArrayList<Product> productLst = new ArrayList<>();
    private String cedulaJuridica;
   private int idUser;
   

    public void insertarProveedor() {

        ServicioUsuario SU = new ServicioUsuario();
        Usuario provedor = new Provedor();

        try {
            
            provedor.setName(this.name);
            provedor.setEmail(this.email);
            provedor.setPassword(this.password);
            provedor.setPhone(this.phone);
            provedor.setTipo(this.tipo);
            ((Provedor) provedor).setCedulaJuridica(cedulaJuridica);
            ((Provedor) provedor).setProductLst(productLst);//???
            ((Provedor) provedor).setIdUser(idUser);
            
            SU.insertar((Provedor) provedor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Provedor() {
    }

    public Provedor(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public ArrayList<Product> getProductLst() {
        return productLst;
    }

    public void setProductLst(ArrayList<Product> productLst) {
        this.productLst = productLst;
    }

    public String getCedulaJuridica() {
        return cedulaJuridica;
    }

    public void setCedulaJuridica(String cedulaJuridica) {
        this.cedulaJuridica = cedulaJuridica;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
}
