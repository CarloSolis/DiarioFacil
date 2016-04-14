/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

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


    }

    public void mostrarProducto() {

        ServicioProducto SP = new ServicioProducto();

        try {
            for (Product p : SP.buscaTodos()) {
                lstProducto.add(new Product( p.getName(), p.getDescription(), p.getPrice(), p.getProvider(), p.getActualStock(), p.getMinimunStock()));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
