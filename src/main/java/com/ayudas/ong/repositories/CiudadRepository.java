package com.ayudas.ong.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ayudas.ong.repositories.entities.Ciudad;


public interface CiudadRepository extends CrudRepository<Ciudad, Long> {

    Ciudad findByNombre(String nombre);
    
}
