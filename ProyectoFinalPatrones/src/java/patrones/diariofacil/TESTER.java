/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jordan
 */
public class TESTER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ServicioUsuario SU = new ServicioUsuario();
        Usuario cliente = new Cliente();

        try {
            cliente.setName("Jordan");
            cliente.setEmail("Jordan@gmail.com");
            cliente.setPassword("qwerty");
            cliente.setPhone(12);
            cliente.setTipo("cliente");
            
            ((Cliente) cliente).setLastName("Wong");
            ((Cliente) cliente).setNumberOfPurchase(2);
            ((Cliente) cliente).setIdUser(7);

            SU.insertar((Cliente) cliente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
