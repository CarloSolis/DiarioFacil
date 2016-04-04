package pat.proyecto.DiarioFacil;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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

    public Usuario create(String name,int phone,String email, String password,String type,int id) throws
            Exception {
        try {
            Connection conn = getConexion();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Usuario VALUES( ?, ?, ?, ?, ? )");
            ps.setString(1, name);
            ps.setInt(2, phone );
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, type);
             ps.setInt(6, id );
            
            ps.executeUpdate();
            return new Usuario(id,name,email, password, type,phone);
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public void delete(String correo) throws Exception {
        // Similar: DELETE FROM sample WHERE id = ?
    }

    public void update(String correo, String password) throws Exception {
        // Similar: UPDATE sample SET name = ?, data = ? WHERE id = ?
    }

    
    public Usuario[] findByName(String correo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public Usuario findById(String correo) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario create(String correo, String password) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   

}
