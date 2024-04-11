package com.ayudas.ong.services.rol.imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayudas.ong.repositories.RolRepository;
import com.ayudas.ong.repositories.entities.Rol;
import com.ayudas.ong.repositories.enums.Roles;
import com.ayudas.ong.services.rol.RolServicesPriv;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RolServiceImpPriv implements RolServicesPriv {

    private final RolRepository rolRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Rol> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    
    @Transactional(readOnly = true)
    @Override
    public Rol findById(final Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    
    @Transactional(readOnly = true)
    @Override
    public Rol findByNombre(final String nombre) {
        if(Roles.exists(nombre)) {
            return rolRepository.findByNombre(Roles.valueOf(nombre));
        }
        else {
            return null;
        }
    }

    
    
}
