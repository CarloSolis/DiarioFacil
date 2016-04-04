/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pat.proyecto.DiarioFacil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author laboratorio
 */
public class ServicioUsuario extends Servicio {

    private static final String INSERTAR = "INSERT INTO USUARIO (NOMBRE,EMAIL,PASSWORD,TIPO,TELEFONO) VALUES(?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM USUARIO WHERE ID = (?)";
     private static final String UPDATE = "UPDATE USUARIO SET NOMBRE =(?),EMAIL=(?),PASSWORD=(?),TIPO=(?),TELEFONO(?) WHERE ID=(?)";
    private static final String BUSCA_TODOS = "SELECT ID, NOMBRE,EMAIL,PASSWORD,TIPO,TELEFONO FROM USUARIO";
   

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
            throw new Exception("No se pudo eliminar el registro.");
        } finally {
            this.desconectar();
        }
    }

    public void Update(Usuario persona) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(UPDATE);
            pstmt.setString(1, persona.getName()); 
            pstmt.setString(2, persona.getEmail()); 
            pstmt.setString(3, persona.getPassword()); 
            pstmt.setString(4, persona.getTipo()); 
            pstmt.setInt(5, persona.getId()); 
            pstmt.setInt(6, persona.getPhone()); 
            
            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo actualizar el registro.");
        } finally {
            this.desconectar();
        }
    }

    public List<Usuario> buscaTodos() throws Exception {
        this.conectar();
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(BUSCA_TODOS);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                String email = rs.getString("EMAIL");
                String password = rs.getString("PASSWORD");
                String tipo = rs.getString("TIPO");
                int telefono = rs.getInt("TELEFONO");
                listaUsuarios.add(new Usuario(id, nombre,email,password,tipo,telefono));
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
