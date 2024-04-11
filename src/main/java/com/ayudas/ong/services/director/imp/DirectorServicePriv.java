package com.ayudas.ong.services.director.imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayudas.ong.repositories.DirectorRepository;
import com.ayudas.ong.repositories.entities.Director;
import com.ayudas.ong.services.director.DirectorServicesPriv;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DirectorServicePriv implements DirectorServicesPriv {

    private final DirectorRepository directorRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Director> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Transactional(readOnly = true)
    @Override
    public Director findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }

    @Transactional(readOnly = true)
    @Override
    public Director findByCedula(long cedula) {
        return directorRepository.findByCedula(cedula).orElse(null);
    }
    
}
