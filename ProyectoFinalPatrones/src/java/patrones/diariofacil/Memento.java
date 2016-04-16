/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

/**
 *
 * @author Cali
 */
public class Memento {

    private String estado;
    private Product product;

    public String getEstado() {
        return estado;
    }

    public Memento(String estado) {
        this.estado = estado;
    }

    public Product getProducto() {
        return product;
    }

    public Memento(Product product) {
        this.product = product;
    }

}
