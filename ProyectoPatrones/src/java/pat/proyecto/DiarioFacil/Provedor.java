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
public class Provedor extends Usuario {

    private ArrayList<Product> productLst = new ArrayList<>();
    private String cedulaJuridica;

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
    
    
}
