package com.ayudas.ong.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ayudas.ong.repositories.entities.Rol;
import com.ayudas.ong.repositories.enums.Roles;


public interface RolRepository extends CrudRepository<Rol,Long> {

    Rol findByNombre(Roles nombre);
    
}
