package com.ayudas.ong.services.ciudad.imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayudas.ong.repositories.CiudadRepository;
import com.ayudas.ong.repositories.entities.Ciudad;
import com.ayudas.ong.services.ciudad.CiudadServicePriv;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CiudadServiceImpPriv implements CiudadServicePriv {

    private final CiudadRepository ciudadRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Ciudad> findAll() {
        return (List<Ciudad>) ciudadRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Ciudad findByNombre(String nombre) {
        return ciudadRepository.findByNombre(nombre);
    }
    
}
