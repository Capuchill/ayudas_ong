package com.ayudas.ong.services.socios.imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayudas.ong.repositories.SocioRepository;
import com.ayudas.ong.repositories.entities.Socio;
import com.ayudas.ong.services.socios.SocioServicesPriv;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SocioServicePrivImp implements SocioServicesPriv {

    private final SocioRepository socioRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Socio> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Transactional(readOnly = true)
    @Override
    public Socio findById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Transactional(readOnly = true)
    @Override
    public Socio findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }

    @Transactional(readOnly = true)
    @Override
    public Socio findByCedula(long cedula) {
        return socioRepository.findByCedula(cedula);
    }
    
}
