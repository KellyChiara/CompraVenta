package com.emergentes.utiles;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConexionBD {
    static String Driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/compraventa";
    static String usuario = "root";
    static String password = "";
    public Connection conn = null;
    public ConexionBD() {
        try{
            Class.forName(Driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null){
                System.out.println("Conexion exitosa");
            }
        }catch(ClassNotFoundException e){
            System.out.println("Falta especificar Driver "+e.getMessage());
        }catch (SQLException e){
            System.out.println("Error al abrir la base de datos "+e.getMessage());
        }
    }
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar BD "+ex.getMessage());
        }
    } 
}
