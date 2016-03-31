package pat.proyecto.DiarioFacil;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pat.proyecto.DiarioFacil.IUsuarioDAO;
import pat.proyecto.DiarioFacil.Servicio;
import pat.proyecto.DiarioFacil.Servicio;
import pat.proyecto.DiarioFacil.Usuario;
import pat.proyecto.DiarioFacil.Usuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cali
 */
public class UsuarioDAOJDBCImpl extends Servicio implements IUsuarioDAO {

    public Usuario create(long id, String nombre) throws
            Exception {
        try {
            Connection conn = getConexion();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO PERSONA VALUES( ?, ? )");
            ps.setLong(1, id);
            ps.setString(2, nombre);
            ps.executeUpdate();
            return new Usuario((int) id, nombre);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public void delete(long id) throws Exception {
        // Similar: DELETE FROM sample WHERE id = ?
    }

    public void update(long id, Usuario model) throws Exception {
        // Similar: UPDATE sample SET name = ?, data = ? WHERE id = ?
    }

    
    public Usuario[] findByName(String nombre) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public Usuario findById(long Id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
