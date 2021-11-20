package com.yesser.dao;

import com.yesser.modelo.Persona;

import java.util.List;

public interface PersonaDao {
    public int delete(int id);
    public List<Persona> findAll();
    public int insert(Persona persona);
    public int update(Persona persona);
}
