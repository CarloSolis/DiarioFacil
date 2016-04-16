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

    public void insertarProveedor() {

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
            user = new Provedor();
            ((Provedor) user).setCedulaJuridica(cedulaJuridica);
            ((Provedor) user).setIdUser(idUser);
            SU.insertarProveedor(((Provedor) user));
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
