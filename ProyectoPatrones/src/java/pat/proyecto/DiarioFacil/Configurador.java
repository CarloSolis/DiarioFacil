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
public class Configurador {

    ArrayList<Product> lstProducto = new ArrayList<Product>();

    public void init() {

        ICatalogo IC = new Categoria();
        SuperMercado SP = new SuperMercado(IC);

        ServicioProducto SPto = new ServicioProducto();
        Product P = new Product();

//        try {
//            P.setName(this.XXXX);
//            P.setRespuesta(XXXX);
//
//            SPto.insertar(P);
//            XXXX = idX();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
    }

    public void mostrarProducto() {

        ServicioProducto SP = new ServicioProducto();

        try {
            for (Product p : SP.buscaTodos()) {
                lstProducto.add(new Product(p.getId(), p.getName(), p.getDescription(), p.getPrice(), p.getProvider(), p.getActualStock(), p.getMinimunStock()));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
