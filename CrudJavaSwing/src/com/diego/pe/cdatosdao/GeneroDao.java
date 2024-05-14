package com.diego.pe.cdatosdao;

import java.sql.Connection;
import java.sql.PreparedStatement;


import com.diego.pe.cmodelo.Genero;

public class GeneroDao {
    private String mensaje = "";
    
    public String AgregarGenero(Connection connection, Genero genero){
        PreparedStatement pst = null;
        String sql = "INSERT INTO GENERO(NOMBRE,ESTADO,SIGLA,CODIGO)" +
                     "VALUES (?,?,?,?)";
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1, genero.getNombre());
            pst.setString(2, genero.getEstado());
            pst.setString(3, genero.getCodigo());
            pst.setString(4, genero.getSigla());
            mensaje = "Se guardo corectamente";
            pst.execute();
            pst.close();
        } catch (Exception e) {
            mensaje = "No se guardo corectamente :" + e.getMessage();
        }
        System.out.println(mensaje);
        return mensaje;
    }
    
    public String ModificarGenero(Connection connection, Genero genero){
        return mensaje;
    }
    
    public String EliminarGenero(Connection connection, int id){
        return mensaje;
    }
    
    public void ListarGenero(Connection connection){
        
    } 
}
