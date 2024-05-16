package com.diego.pe.cdatosdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.diego.pe.cmodelo.Genero;
import javax.swing.JTable;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GeneroDao {
    private String mensaje = "";
    
    public String AgregarGenero(Connection connection, Genero genero){
        PreparedStatement ps = null;
        String sql = "INSERT INTO GENERO(NOMBRE,ESTADO,SIGLA,CODIGO)" +
                     "VALUES (?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, genero.getNombre());
            ps.setString(2, genero.getEstado());
            ps.setString(3, genero.getCodigo());
            ps.setString(4, genero.getSigla());
            mensaje = "Se Insertó correctamente";
            ps.execute();
            ps.close();
        } catch (Exception e) {
            mensaje = "No se Insertó correctamente :" + e.getMessage();
        }
        System.out.println(mensaje);
        return mensaje;
    }
    
    public String ModificarGenero(Connection connection, Genero genero){
        PreparedStatement ps = null;
        String sql = "UPDATE GENERO SET NOMBRE = ?, ESTADO = ?, SIGLA = ?, CODIGO = ? " +
                     "WHERE ID_GENERO = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, genero.getNombre());
            ps.setString(2, genero.getEstado());
            ps.setString(3, genero.getCodigo());
            ps.setString(4, genero.getSigla());
            ps.setInt(5, genero.getIdGnero());
            mensaje = "Se Modificó correctamente";
            ps.execute();
            ps.close();
        } catch (Exception e) {
            mensaje = "No se Modificó correctamente :" + e.getMessage();
        }
        System.out.println(mensaje);
        return mensaje;
    }
    
    public String EliminarGenero(Connection connection, int id){
        PreparedStatement ps = null;
        String sql = "DELETE FROM GENERO WHERE ID_GENERO = ? ";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            mensaje = "Se eliminó correctamente";
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            mensaje = "No Se eliminó correctamente :" + e.getMessage();
        }
        return mensaje;
    }
    
    public void ListarGenero(Connection connection, JTable jTable){
        
        Statement statement = null;
        ResultSet resultSet = null;
        DefaultTableModel model;
        
        String[] columnas = {"ID","NOMBRE", "ESTADO", "SIGLA", "CODIGO"};
        model = new DefaultTableModel(null, columnas);
        
        String sql = "SELECT * FROM genero " +
                    "ORDER BY id_genero DESC";
        
        String[] filas = new String[8];
        
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            
            while(resultSet.next()){
                for(int i=0; i<8; i++){
                    filas[i] = resultSet.getString(i+1);
                }
                model.addRow(filas);
            }
            jTable.setModel(model);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puedo mostrar la tabla");
        }
        
    } 
}
