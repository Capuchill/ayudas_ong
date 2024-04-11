package com.ayudas.ong.services.director;

import java.util.List;

import com.ayudas.ong.repositories.entities.Director;

public interface DirectorServicesPriv {
    
    List<Director> findAll();

    Director findByEmail(final String email);

    Director findByCedula(long cedula);

}
