package com.yesser.dao;


import com.yesser.conexion.Conexion;
import com.yesser.modelo.Empleado;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class EmpleadoDaoImpl implements EmpleadoDao {

    @Override
    public int delete(int id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Empleado> findAll() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(Empleado empleado) {
        int registrar = -1;

        Statement stm= null;
        Connection con=null;

        String sql="INSERT INTO empleado values (NULL,'"+empleado.getNombre()+"')";

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
    public int update(Empleado empleado) {
        int update = -1;

        Statement stm= null;
        Connection con=null;
        String sql="UPDATE empleado SET nombre = '"+empleado.getNombre()+ "' WHERE id = 1";
        try {
            con= Conexion.conectar();
            stm= con.createStatement();
            stm.execute(sql);
            update=1;
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Error: Clase ClienteDaoImple, método registrar");
            e.printStackTrace();
        }
        return update;
        
    }
    
}
