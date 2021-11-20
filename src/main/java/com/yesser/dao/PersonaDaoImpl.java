package com.yesser.dao;

import com.yesser.conexion.Conexion;
import com.yesser.modelo.Persona;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PersonaDaoImpl implements PersonaDao {
    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<Persona> findAll() {
        return null;
    }

    @Override
    public int insert(Persona persona) {
        int registrar = -1;

        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO persona values (NULL,'"+persona.getNombre()+"')";

        try {
            con= Conexion.conectar();
            stm= con.createStatement();
            stm.execute(sql);
            registrar=1;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método registrar");
            e.printStackTrace();
        }
        return registrar;
    }

    @Override
    public int update(Persona persona) {
    

        return 0;
    }
}
