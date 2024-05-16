package com.diego.pe.ctest;

import com.diego.pe.cmodelo.Genero;
import com.diego.pe.cnegocio.GeneroBO;
import java.sql.SQLException;


public class Test {
    GeneroBO generoBO = new GeneroBO();
    Genero genero = new Genero();
    
    public void insertar() throws SQLException{
        genero.setNombre("Diego");
        genero.setEstado("1");
        genero.setSigla("D");
        genero.setCodigo("D");
        
        generoBO.AgregarGenero(genero);
    }
    
    public  void modificar() throws SQLException{
        genero.setIdGnero(130);
        genero.setNombre("Diego 1");
        genero.setEstado("0");
        genero.setSigla("d");
        genero.setCodigo("d");
       
        generoBO.ModificarGenero(genero);
    }
    
    public void eliminar() throws SQLException{
        generoBO.EliminarGenero(130);
    }
    
    public static void main(String[] args) throws SQLException {
        Test t = new Test();
        //t.insertar();
        //t.modificar();
        t.eliminar();
    }
}
