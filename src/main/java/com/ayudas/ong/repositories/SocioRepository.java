package com.ayudas.ong.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ayudas.ong.repositories.entities.Socio;

public interface SocioRepository extends CrudRepository<Socio, Long> {
    
    Optional<Socio> findByEmail(final String email);

    Socio findByCedula(long cedula);

}
