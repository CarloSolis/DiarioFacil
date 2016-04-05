/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat.proyecto.DiarioFacil;
import java.util.Date;

/**
 *
 * @author Cali
 */
public class Orden {

    private Date fecha = new Date();
    private int total;
    private int billNumber;
    private Carro cart;

    public Orden() {
    }

    public Orden(Carro cart) {
        this.cart = cart;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(int billNumber) {
        this.billNumber = billNumber;
    }

    public Carro getCart() {
        return cart;
    }

    public void setCart(Carro cart) {
        this.cart = cart;
    }

}
