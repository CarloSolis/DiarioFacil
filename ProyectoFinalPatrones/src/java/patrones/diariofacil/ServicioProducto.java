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
public class ServicioProducto extends Servicio {

    private static final String INSERTAR = "INSERT INTO PRODUCTO (PRODUCTONOMBRE,DESCRIPCION,PRECIO,STOCKMINIMO,STOCKACTUAL,PROVEEDOR_IDPROVEEDOR,CATEGORIA_IDCATEGORIA) VALUES(?,?,?,?,?,?,?)";
    private static final String DELETE = "DELETE FROM PRODUCTO WHERE IDPRODUCTO = (?)";
    private static final String UPDATE = "UPDATE PRODUCTO SET PRODUCTONOMBRE =(?),DESCRIPCION=(?),PRECIO=(?),PROVEEDOR_IDPROVEEDOR=(?),STOCKMINIMO=(?),STOCKACTUAL=(?) WHERE IDPRODUCTO=(?)";
    private static final String BUSCA_TODOS = "SELECT IDPRODUCTO, PRODUCTONOMBRE,DESCRIPCION,PRECIO,PROVEEDOR_IDPROVEEDOR,STOCKMINIMO,STOCKACTUAL,CATEGORIA_IDCATEGORIA FROM PRODUCTO";
    private static final String BUSCA_UNO = "SELECT IDPRODUCTO, PRODUCTONOMBRE,DESCRIPCION,PRECIO,PROVEEDOR_IDPROVEEDOR,STOCKMINIMO,STOCKACTUAL,CATEGORIA_IDCATEGORIA FROM PRODUCTO WHERE PRODUCTONOMBRE = (?)";

    public void insertar(Product producto) throws Exception {

        this.conectar();
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(INSERTAR);

            pstmt.setString(1, producto.getName());
            pstmt.setString(2, producto.getDescription());
            pstmt.setInt(3, producto.getPrice()); 
            pstmt.setInt(4, producto.getMinimunStock());
            pstmt.setInt(5, producto.getActualStock());
            pstmt.setInt(6, producto.getIdProvider());
            pstmt.setInt(7, producto.getIdCategory());

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
            //Aqui jalaba un provider
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(BUSCA_TODOS);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("NOMBRE");
                String description = rs.getString("DESCRIPCION");
                int price = rs.getInt("PRECIO");
                int minimunStock = rs.getInt("STOCKMIN");
                int actualStock = rs.getInt("STOCKACTUAL");
                lstProduct.add(new Product(id, nombre, description, price, minimunStock, actualStock));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo buscar el registro.");
        } finally {
            this.desconectar();
        }

        return lstProduct;
    }

    public Product buscaPorNombre(String nombre) throws Exception {
        this.conectar();
        Product product = null;
        try {
            PreparedStatement pstmt = this.getConexion().prepareStatement(BUSCA_UNO);
            
            pstmt.setString(1, nombre);
            
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("ID");
                String nombreBBDD = rs.getString("NOMBRE");
                String description = rs.getString("DESCRIPCION");
                int price = rs.getInt("PRECIO");
                int minimunStock = rs.getInt("STOCKMIN");
                int actualStock = rs.getInt("STOCKACTUAL");
                product = new Product(id, nombreBBDD, description, price, minimunStock, actualStock);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se pudo buscar el registro.");
        } finally {
            this.desconectar();
        }

        return product;
    }

}
