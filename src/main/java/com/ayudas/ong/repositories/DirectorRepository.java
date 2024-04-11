package com.ayudas.ong.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ayudas.ong.repositories.entities.Director;

public interface DirectorRepository extends CrudRepository<Director, Long> {
    
    Optional<Director> findByCedula(long cedula);

    Optional<Director> findByEmail(String email);
}
