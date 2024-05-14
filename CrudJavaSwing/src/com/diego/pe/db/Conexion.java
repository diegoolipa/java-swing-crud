
package com.diego.pe.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class Conexion {
    // Declaración de variables estáticas para la conexión
    private static Connection conn = null;
    private static String login = "USUARIO_MATRICULA"; // Usuario de la base de datos
    private static String clave = "123456"; // Contraseña de la base de datos
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe"; // URL de conexión a la base de datos

    // Método estático para obtener la conexión a la base de datos
    public static Connection getConnection() {
        try {
            // Cargar el controlador JDBC
            Class.forName("oracle.jdbc.OracleDriver");
            // Establecer la conexión con la base de datos
            conn = DriverManager.getConnection(url, login, clave);
            // Deshabilitar el autocommit para manejar transacciones manualmente
            conn.setAutoCommit(false);
            
            System.out.println("======================================================");
            System.out.println("✅ Diego Frank Lipa Choque");
            System.out.println("======================================================");
            
            // Verificar si la conexión se ha establecido con éxito
            if (conn != null) {
                System.out.println("Conexión Exitosa");
            } else {
                System.out.println("Alto: Conexión Fallida");
            }
        } catch (ClassNotFoundException | SQLException e) {
            // Mostrar un mensaje de error en caso de excepción
            JOptionPane.showConfirmDialog(null, "Alto: Conexión Fallida " + e.getMessage());
        }
        // Devolver la conexión establecida
        return conn;
    }
    
    // Método para cerrar la conexión a la base de datos
    public void closeConnection() {
        try {
            // Cerrar la conexión
            conn.close();
        } catch (Exception e) {
            // Mostrar un mensaje de error en caso de excepción al cerrar la conexión
            System.out.println("Alto: error al desconectar"+ e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Conexion c = new Conexion();
        c.getConnection();
    }
}
