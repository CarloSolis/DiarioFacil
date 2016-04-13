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

}
