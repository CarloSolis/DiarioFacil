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
import pat.proyecto.DiarioFacil.Servicio;
import pat.proyecto.DiarioFacil.Usuario;

/**
 *
 * @author laboratorio
 */
public class ServicioUsuario extends Servicio {

    private static final String INSERTAR = "INSERT INTO PERSONA (NOMBRE) VALUES (?)";
    private static final String BUSCA_TODOS = "SELECT ID, NOMBRE FROM Persona";
    private static final String DELETE = "DELETE FROM PERSONA WHERE id = ?";
    private static final String UPDATE = "UPDATE PERSONA set NOMBRE = ?";

    public void insertar(Usuario persona) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(INSERTAR);
            //--pstmt.setInt(1, persona.getId()); -- Porque es Autoincremental
            pstmt.setString(1, persona.getName());
            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se puedo insertar el registro.");
        } finally {
            this.desconectar();
        }
    }

    public void Delete(Usuario persona) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(DELETE);
            //--pstmt.setInt(1, persona.getId()); -- Porque es Autoincremental
            pstmt.setInt(1, persona.getId());
            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se puedo eliminar el registro.");
        } finally {
            this.desconectar();
        }
    }

    public void UpDate(Usuario persona) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(UPDATE);
            //--pstmt.setInt(1, persona.getId()); -- Porque es Autoincremental
            pstmt.setString(1, persona.getName()); //REVISAR .SETNOMBRE!!!
            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se puedo actualizar el registro.");
        } finally {
            this.desconectar();
        }
    }

    public List<Usuario> buscaTodos() throws Exception {
        this.conectar();
        ArrayList<Usuario> lstPersonas = new ArrayList<>();

        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(BUSCA_TODOS);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                lstPersonas.add(new Usuario(id, nombre));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se puedo insertar el registro.");
        } finally {
            this.desconectar();
        }

        return lstPersonas;
    }

}
