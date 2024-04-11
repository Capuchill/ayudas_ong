package com.ayudas.ong.services.sede.imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayudas.ong.repositories.SedeRepository;
import com.ayudas.ong.repositories.entities.Sede;
import com.ayudas.ong.services.sede.SedeServicesPriv;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SedeServiceImpPriv implements SedeServicesPriv {

    private final SedeRepository sedeRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Sede> findAll() {
        return (List<Sede>) sedeRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Sede findById(final Long id) {
        return sedeRepository.findById(id).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public Sede findByNombre(final String nombre) {
        return sedeRepository.findByNombre(nombre);
    }
    
}
