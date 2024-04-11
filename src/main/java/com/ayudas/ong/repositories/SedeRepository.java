package com.ayudas.ong.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ayudas.ong.repositories.entities.Sede;


public interface SedeRepository extends CrudRepository<Sede,Long> {

    Sede findByNombre(String nombre);
    
}
