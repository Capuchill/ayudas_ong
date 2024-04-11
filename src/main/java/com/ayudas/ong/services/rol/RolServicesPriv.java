package com.ayudas.ong.services.rol;

import java.util.List;

import com.ayudas.ong.repositories.entities.Rol;

public interface RolServicesPriv {

    List<Rol> findAll();

    Rol findById(final Long id);

    Rol findByNombre(final String nombre);

}
