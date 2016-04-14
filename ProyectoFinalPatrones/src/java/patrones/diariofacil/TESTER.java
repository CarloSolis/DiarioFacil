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
        Usuario proveedor = new Provedor();
//        try {
//            cliente.setName("Jordan");
//            cliente.setEmail("Jordan@gmail.com");
//            cliente.setPassword("qwerty");
//            cliente.setPhone(12);
//            cliente.setTipo("cliente");
//            
//            ((Cliente) cliente).setLastName("Wong");
//            ((Cliente) cliente).setNumberOfPurchase(2);
//            ((Cliente) cliente).setIdUser(8);
//
//            SU.insertar((Cliente) cliente);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        
//         try {
//            proveedor.setName("Jordan");
//            proveedor.setEmail("Jordan@gmail.com");
//            proveedor.setPassword("qwerty");
//            proveedor.setPhone(12);
//            proveedor.setTipo("proveedor");
//            
//            ((Provedor) proveedor).setCedulaJuridica("123456");
//            ((Provedor) proveedor).setIdUser(14);
//
//            SU.insertar((Provedor) proveedor);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        
          try {
            
           ((Provedor) proveedor).setIdUser(12);
            ((Provedor) proveedor).setId(12);
            SU.Delete((Provedor) proveedor);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
