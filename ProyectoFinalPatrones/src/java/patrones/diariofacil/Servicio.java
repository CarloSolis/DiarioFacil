/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patrones.diariofacil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author laboratorio
 */
public abstract class Servicio {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "localhost";
    private static final String PORT = "3306";
    private static final String SID = "mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";//"jordan";//
    private Connection conexion = null;

    public Servicio() {
    }
    
    protected void conectar() throws Exception {
    
        try {
            Class.forName(DRIVER);
            this.conexion = DriverManager.getConnection("jdbc:mysql://"+URL+":"+PORT+"/"+SID, USER, PASSWORD);
            System.out.println("ME CONECTE A LA BASE DATOS");
            
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            throw new Exception("Driver Incorrecto");
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new Exception("No se puede conectar a la base de datos. Revise parametros.");
        }
    }
    
    protected void desconectar() throws Exception {
        
        if (this.conexion != null) {
            try {
                this.conexion.close();
                System.out.println("ME DESCONECTE A LA BASE DATOS");
            } catch (SQLException ex) {
                throw new Exception("No se puede desconectar a la base de datos.");
            }
        }
    }
    
    protected  Connection getConexion() {
        return this.conexion;
    }
}
