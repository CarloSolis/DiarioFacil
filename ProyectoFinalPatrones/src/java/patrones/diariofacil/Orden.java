 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;
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

     @Override
    public String toString() {

        StringBuffer sb = new StringBuffer();

        sb.append("Nombre: " + this.getCart().getClient().getName()+" "+this.getCart().getClient().getLastName() + "\n");
        sb.append("Fecha: " + fecha + "\n");
        sb.append("--------------------------------------------" + "\n");
        sb.append("" + "\n");
        sb.append("Nombre" + "\t" + "   " + " Cantidad" + "  " + " Descuento" + "  " + "Total" + "\n");

        for (Item i : cart.itemList) {

            sb.append(i.getProduct().getName() + "\t" + i.getQuantity() + "\t" + i.FinalTotal() + "\n");

            i.getProduct().setActualStock(i.getQuantity() - i.getProduct().getActualStock());

            total += i.FinalTotal();

        }
        
       

        sb.append("Total: ₡" + total + "\n");

        sb.append("____________________________________________" + "\n");
        sb.append("____________________________________________" + "\n");

        return sb.toString();
    }
    
}
