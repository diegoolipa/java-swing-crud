
package com.diego.pe.cnegocio;

import java.sql.Connection;
import java.sql.SQLException;

import com.diego.pe.cdatosdao.GeneroDao;
import com.diego.pe.cmodelo.Genero;
import com.diego.pe.db.Conexion;
import javax.swing.JTable;

public class GeneroBO {
    private String mensaje = "";
    private Genero genero = new Genero();
    private GeneroDao generoDao = new GeneroDao();
    
    public String AgregarGenero(Genero genero) throws SQLException{
        Connection connection = Conexion.getConnection();
        try {
            mensaje = generoDao.AgregarGenero(connection, genero);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.close();
        }
        System.out.println(mensaje);
        return mensaje;
    }
    
    public String ModificarGenero(Genero genero) throws SQLException{
        Connection connection = Conexion.getConnection();
        try {
            mensaje = generoDao.ModificarGenero(connection, genero);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.close();
        }
        System.out.println(mensaje);
        return mensaje;
    }
    
    public String EliminarGenero(int id) throws SQLException{
        Connection connection = Conexion.getConnection();
        try {
            mensaje = generoDao.EliminarGenero(connection, id);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
        } finally {
            connection.close();
        }
        System.out.println(mensaje);
        return mensaje;
    }
    
    public void ListarGenero(JTable table){
        Connection connection = Conexion.getConnection();
        try {
            generoDao.ListarGenero(connection, table);
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error al listar Genero"+ e.getMessage());
        } 
        System.out.println(mensaje);
    }
}
