package com.ayudas.ong.services.sede;

import java.util.List;

import com.ayudas.ong.repositories.entities.Sede;

public interface SedeServicesPriv {

    List<Sede> findAll();

    Sede findById(final Long id);

    Sede findByNombre(final String nombre);

}
