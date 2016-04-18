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
 * @author Jordan
 */
public class ServicioCategoria extends Servicio{
    
    private static final String INSERTAR = "INSERT INTO CATEGORIA (CATEGORIANOMBRE) VALUES(?)";
    private static final String DELETE = "DELETE FROM CATEGORIA WHERE IDCATEGORIA = (?)";
    private static final String UPDATE = "UPDATE CATEGORIA SET CATEGORIANOMBRE =(?) WHERE IDCATEGORIA=(?)";
    private static final String BUSCA_TODOS = "SELECT IDCATEGORIA, CATEGORIANOMBRE FROM CATEGORIA";

    
     public void insertarCategoria(Categoria categoria) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(INSERTAR);

            pstmt.setString(1, categoria.getNombreCategoria());
    
            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo insertar la categoría.");
        }finally {
            this.desconectar();
        }
    }
     
      public void Delete(Categoria categoria) throws Exception {

        this.conectar();

        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(DELETE);
            pstmt.setInt(1, categoria.getId());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo eliminar la categoria.");
        } finally {
            this.desconectar();
        }
    }
      
      public void Update(Categoria categoria) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(UPDATE);
            
            pstmt.setString(1, categoria.getNombreCategoria());        
            pstmt.setInt(2, categoria.getId());
            
            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo actualizar la categoria.");
        } finally {
            this.desconectar();
        }
    }
    
     public List<Categoria> buscaTodos() throws Exception {
        this.conectar();
        ArrayList<Categoria> listaCategoria = new ArrayList<>();

        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(BUSCA_TODOS);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("IDCATEGORIA");
                String nombre = rs.getString("CATEGORIANOMBRE");
               
                listaCategoria.add(new Categoria( nombre,id));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo buscar el registro.");
        } finally {
            this.desconectar();
        }

        return listaCategoria;
    } 
    
}
