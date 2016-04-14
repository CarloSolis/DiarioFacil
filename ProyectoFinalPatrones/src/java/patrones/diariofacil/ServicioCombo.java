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
public class ServicioCombo extends Servicio {

    private static final String INSERTAR = "INSERT INTO USUARIO (NOMBRE,DESCRIPCION,PRECIO,PROVEDOR,STOCKMIN,STOCKACTUAL) VALUES(?,?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM USUARIO WHERE ID = (?)";
    private static final String UPDATE = "UPDATE USUARIO SET NOMBRE =(?),DESCRIPCION=(?),PRECIO=(?),PROVEDOR=(?),STOCKMIN=(?),STOCKACTUAL=(?) WHERE ID=(?)";
    private static final String BUSCA_TODOS = "SELECT ID, NOMBRE,DESCRIPCION,PRECIO,PROVEDOR,STOCKMIN,STOCKACTUAL FROM PRODUCTO";
    private static final String BUSCA_UNO = "SELECT ID, NOMBRE,DESCRIPCION,PRECIO,PROVEDOR,STOCKMIN,STOCKACTUAL FROM PRODUCTO WHERE NOMBRE = ?";

    public void insertar(Combo cb) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(INSERTAR);

            pstmt.setString(1, cb.getNombre());
            pstmt.setObject(2, cb.getLstProducto());

            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo insertar el registro.");
        } finally {
            this.desconectar();
        }
    }

    public void Delete(Combo cb) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(DELETE);
            pstmt.setInt(1, cb.getId());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo eliminar el registro.");
        } finally {
            this.desconectar();
        }
    }

    public void Update(Combo cb) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(UPDATE);

            pstmt.setString(1, cb.getNombre());
            pstmt.setObject(2, cb.getLstProducto());
            
            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo actualizar el registro.");
        } finally {
            this.desconectar();
        }
    }

    public List<Combo> buscaTodos() throws Exception {
        this.conectar();
        ArrayList<Combo> lstProduct = new ArrayList<>();

        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(BUSCA_TODOS);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                //Product productos = rs.getObject("Producto");
                
                lstProduct.add(new Combo(nombre));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo buscar el registro.");
        } finally {
            this.desconectar();
        }

        return lstProduct;
    }

    public Combo buscaPorNombre(String nombre) throws Exception {
        this.conectar();
        Combo combo = null;
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(BUSCA_UNO);
            
            pstmt.setString(1, nombre);
            
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID");
                String nombreBBDD = rs.getString("NOMBRE");
                String description = rs.getString("DESCRIPCION");
                int price = rs.getInt("PRECIO");
                int provider = rs.getInt("PROVEDOR");
                int minimunStock = rs.getInt("STOCKMIN");
                int actualStock = rs.getInt("STOCKACTUAL");
                combo = new Combo(nombre);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo buscar el registro.");
        } finally {
            this.desconectar();
        }

        return combo;
    }
    
}
