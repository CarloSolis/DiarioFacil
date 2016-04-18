/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

import java.util.ArrayList;
import java.util.List;
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
        Usuario user = new Usuario();
        Usuario cliente = new Cliente();
        Usuario proveedor = new Provedor();
        Caretaker ct = new Caretaker();

//        try {
//            user.setName("Jordan");
//            user.setEmail("Jordan@gmail.com");
//            user.setPassword("qwerty");
//            user.setPhone(12);
//            user.setTipo("cliente");
//            
//            SU.insertar(user);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        try {
//              ((Cliente) cliente).setLastName("Wong");
//            ((Cliente) cliente).setNumberOfPurchase(3);
//            ((Cliente) cliente).setIdUser(32);
//            SU.insertarCliente(((Cliente) cliente));
//        }catch (Exception ex) {
//            ex.printStackTrace();
//        }
//            ///////////////buscartodos
//        try {
//
//            for (Usuario usuario : SU.buscaTodos()) {
//                System.out.println("ID: " + usuario.getId() + " email: " + usuario.getEmail() + " Nombre: " + usuario.getName());
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//
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
//        
//            /////////////////Delete//////////
//          try {
//            
//           ((Cliente) cliente).setIdUser(43);
//           SU.DeleteCliente((Cliente) cliente); 
//          
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//           try {
//           user.setId(43);
//            SU.Delete(user);
//       } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        ///////////Update////
//        try {
//            user.setName("Jordan SA");
//           
//            user.setPassword("11");
//            user.setTipo("Proveedor");
//            user.setPhone(987);
//            user.setId(44);
//            SU.Update(user);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        try {
//            ((Provedor) proveedor).setCedulaJuridica("1");
//
//            ((Provedor) proveedor).setIdUser(44);
//            SU.UpdateProveedor((Provedor) proveedor);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        try {
//            ((Cliente) cliente).setLastName("Yeung");
//
//            ((Cliente) cliente).setIdUser(40);
//            SU.UpdateCliente(((Cliente) cliente));
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        ServicioProducto SP = new ServicioProducto();
//        Product p = new Product();
//
//        try {
//            p.setName("CocaCola");
//            p.setDescription("800ml");
//            p.setPrice(12000);
//            p.setMinimunStock(150);
//            p.setActualStock(900);
//            p.setProvider(null);
//
//            SP.insertar(p);
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//        Product product = new Product("Coca~Cola", "Bebida 800ml", 950, (Provedor) proveedor, 15, 15);
//        product.setProduct(product);
//        ct.addMemento(product.saveToMemento());
//        product = new Product("Coca~ColaS", "Bebida 800ml", 950, (Provedor) proveedor, 15, 15);
//        product.setProduct(product);
//        ct.addMemento(product.saveToMemento());
//
//        Memento m = ct.getMemento(0);
//        Memento m1 = ct.getMemento(1);
//
//        System.out.println(m.getProducto());
//        System.out.println(m1.getProducto());
        List<Provedor> listaProvedor = new ArrayList<Provedor>();
        try {

            for (Provedor prove : SU.buscaTodos()) {
                listaProvedor.add(new Provedor( prove.getIdProvider(),prove.getName()));

            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        System.out.println(listaProvedor);

    }

}
