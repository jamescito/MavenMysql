package com.yesser.dao;

import java.util.List;

import com.yesser.modelo.Empleado;

public interface EmpleadoDao {
    public int delete(int id);
    public List<Empleado> findAll();
    public int insert(Empleado empleado);
    public int update(Empleado empleado);
}
