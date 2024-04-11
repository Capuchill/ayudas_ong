package com.ayudas.ong.services.socios;

import java.util.List;

import com.ayudas.ong.repositories.entities.Socio;

public interface SocioServicesPriv {

    List<Socio> findAll();

    Socio findById(final long id);

    Socio findByEmail(final String email);

    Socio findByCedula(long cedula);
    
}
