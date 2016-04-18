/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cali
 */
public class ServicioUsuario extends Servicio {

    private static final String INSERTAR = "INSERT INTO USUARIO (NOMBRE,EMAIL,PASSWORD,TIPO,TELEFONO) VALUES(?,?,?,?,?)";
    private static final String INSERTARCLIENTE = "INSERT INTO CLIENTE (APELLIDO,NUMEROCOMPRAS,IDUSUARIO) VALUES(?,?,?)";
    private static final String INSERTARPROVEEDOR = "INSERT INTO PROVEEDOR (CEDULAJURIDICA,USUARIO_IDUSUARIO) VALUES(?,?)";
    private static final String DELETE = "DELETE FROM USUARIO WHERE IDUSUARIO = (?)";
    private static final String DELETECLIENTE = "DELETE FROM CLIENTE WHERE IDUSUARIO = (?)";
    private static final String DELETEPROVEEDOR = "DELETE FROM PROVEEDOR WHERE USUARIO_IDUSUARIO = (?)";
    private static final String UPDATE = "UPDATE USUARIO SET NOMBRE =(?),PASSWORD=(?),TIPO=(?),TELEFONO=(?) WHERE IDUSUARIO=(?)";
    private static final String UPDATECLIENTE = "UPDATE CLIENTE SET APELLIDO =(?) WHERE IDUSUARIO=(?)";
    private static final String UPDATEPROVEEDOR = "UPDATE PROVEEDOR SET CEDULAJURIDICA =(?) WHERE USUARIO_IDUSUARIO=(?)";
    private static final String BUSCAPROVEEDOR = "SELECT IDUSUARIO, NOMBRE,EMAIL,PASSWORD,TIPO,TELEFONO,CEDULAJURIDICA,USUARIO_IDUSUARIO,IDPROVEEDOR FROM USUARIO,PROVEEDOR WHERE IDUSUARIO=USUARIO_IDUSUARIO";


    public void insertar(Usuario persona) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(INSERTAR);

            pstmt.setString(1, persona.getName());
            pstmt.setString(2, persona.getEmail());
            pstmt.setString(3, persona.getPassword());
            pstmt.setString(4, persona.getTipo());
            pstmt.setInt(5, persona.getPhone());

            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo insertar el registro.");
        }
    }

    public void insertarCliente(Cliente persona) throws Exception {

        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(INSERTARCLIENTE);

            pstmt.setString(1, ((Cliente) persona).getLastName());
            pstmt.setInt(2, ((Cliente) persona).getNumberOfPurchase());
            pstmt.setInt(3, ((Cliente) persona).getIdUser());

            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo insertar el cliente.");

        } finally {
            this.desconectar();

        }
    }

    public void insertarProveedor(Provedor persona) throws Exception {

        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(INSERTARPROVEEDOR);

            pstmt.setString(1, ((Provedor) persona).getCedulaJuridica());
            pstmt.setInt(2, ((Provedor) persona).getIdUser());

            pstmt.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo insertar el proveedor.");
        } finally {
            this.desconectar();

        }

    }

    public void Delete(Usuario persona) throws Exception {

        this.conectar();

        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(DELETE);
            pstmt.setInt(1, persona.getId());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo eliminar el usuario.");
        } finally {
            this.desconectar();
        }
    }

    public void DeleteCliente(Cliente persona) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(DELETECLIENTE);
            pstmt.setInt(1, ((Cliente) persona).getIdUser());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo eliminar el cliente.");
        }
    }

    public void DeleteProveedor(Provedor persona) throws Exception {
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(DELETEPROVEEDOR);
            pstmt.setInt(1, ((Provedor) persona).getIdUser());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo eliminar el proveedor.");
        }
    }

    public void Update(Usuario persona) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(UPDATE);

            pstmt.setString(1, persona.getName());
            pstmt.setString(2, persona.getPassword());
            pstmt.setString(3, persona.getTipo());
            pstmt.setInt(4, persona.getPhone());
            pstmt.setInt(5, persona.getId());

            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo actualizar el usuario.");
        } finally {
            this.desconectar();
        }
    }

    public void UpdateCliente(Cliente persona) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(UPDATECLIENTE);
            pstmt.setString(1, persona.getLastName());
            pstmt.setInt(2, persona.getIdUser());

            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo actualizar el cliente.");

        } finally {
            this.desconectar();
        }
    }

    public void UpdateProveedor(Provedor persona) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(UPDATEPROVEEDOR);
            pstmt.setString(1, persona.getCedulaJuridica());
            pstmt.setInt(2, persona.getIdUser());

            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo actualizar el proveedor.");

        } finally {
            this.desconectar();
        }

    }

    public List<Provedor> buscaTodos() throws Exception {
        this.conectar();
        ArrayList<Provedor> listaUsuarios = new ArrayList<>();

        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(BUSCAPROVEEDOR);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IDUSUARIO");
                String nombre = rs.getString("NOMBRE");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                String tipo = rs.getString("TIPO");
                int telefono = rs.getInt("TELEFONO");
               int idProveedor = rs.getInt("IDPROVEEDOR");
                String cj = rs.getString("CEDULAJURIDICA");
                int idUser = rs.getInt("USUARIO_IDUSUARIO");
                
                listaUsuarios.add(new Provedor(cj , idUser,idProveedor, id, nombre, email, password, tipo, telefono));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo buscar el registro.");
        } finally {
            this.desconectar();
        }

        return listaUsuarios;
    }

}
