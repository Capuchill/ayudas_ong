package com.ayudas.ong.services.ciudad;

import java.util.List;

import com.ayudas.ong.repositories.entities.Ciudad;

public interface CiudadServicePriv {

    List<Ciudad> findAll();

    Ciudad findByNombre(final String nombre);
    
}
