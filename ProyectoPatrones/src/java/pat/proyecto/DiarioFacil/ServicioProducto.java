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
 * @author Cali
 */

public class ServicioProducto extends Servicio {

    private static final String INSERTAR = "INSERT INTO USUARIO (NOMBRE,DESCRIPCION,PRECIO,PROVEDOR,STOCKMIN,STOCKACTUAL) VALUES(?,?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM USUARIO WHERE ID = (?)";
    private static final String UPDATE = "UPDATE USUARIO SET NOMBRE =(?),DESCRIPCION=(?),PRECIO=(?),PROVEDOR=(?),STOCKMIN=(?),STOCKACTUAL=(?) WHERE ID=(?)";
    private static final String BUSCA_TODOS = "SELECT ID, NOMBRE,DESCRIPCION,PRECIO,PROVEDOR,STOCKMIN,STOCKACTUAL FROM PRODUCTO";

    public void insertar(Product producto) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(INSERTAR);

            pstmt.setString(1, producto.getName());
            pstmt.setString(2, producto.getDescription());
            pstmt.setInt(3, producto.getPrice());
            pstmt.setInt(4, producto.getProvider().getId()); //APUESTA
            pstmt.setInt(5, producto.getMinimunStock());
            pstmt.setInt(6, producto.getActualStock());

            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo insertar el registro.");
        } finally {
            this.desconectar();
        }
    }

    public void Delete(Product producto) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(DELETE);
            pstmt.setInt(1, producto.getId());
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo eliminar el registro.");
        } finally {
            this.desconectar();
        }
    }

    public void Update(Product producto) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(UPDATE);

            pstmt.setString(1, producto.getName());
            pstmt.setString(2, producto.getDescription());
            pstmt.setInt(3, producto.getPrice());
            pstmt.setObject(4, producto.getProvider());
            pstmt.setInt(5, producto.getMinimunStock());
            pstmt.setInt(6, producto.getActualStock());

            pstmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo actualizar el registro.");
        } finally {
            this.desconectar();
        }
    }

    public List<Product> buscaTodos() throws Exception {
        this.conectar();
        ArrayList<Product> lstProduct = new ArrayList<>();

        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(BUSCA_TODOS);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                String description = rs.getString("DESCRIPCION");
                int price = rs.getInt("PRECIO");
                int provider = rs.getInt("PROVEDOR");
                int minimunStock = rs.getInt("STOCKMIN");
                int actualStock = rs.getInt("STOCKACTUAL");
                //listaUsuarios.add(new Usuario(id, nombre, description, price, provider, minimunStock, actualStock));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo buscar el registro.");
        } finally {
            this.desconectar();
        }

        return lstProduct;
    }

}
