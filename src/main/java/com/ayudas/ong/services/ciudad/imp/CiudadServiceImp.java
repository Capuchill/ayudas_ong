package com.ayudas.ong.services.ciudad.imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayudas.ong.repositories.CiudadRepository;
import com.ayudas.ong.repositories.models.dtos.CiudadDTO;
import com.ayudas.ong.services.ciudad.CiudadService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CiudadServiceImp implements CiudadService {

    private final CiudadRepository ciudadRepository;

    @Transactional(readOnly = true)
    @Override
    public List<CiudadDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Transactional
    @Override
    public CiudadDTO crear(CiudadDTO ciudadDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Transactional
    @Override
    public CiudadDTO save(CiudadDTO sedeDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Transactional
    @Override
    public CiudadDTO update(Long id, CiudadDTO sedeDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Transactional
    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Transactional(readOnly = true)
    @Override
    public CiudadDTO findByNombre(String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNombre'");
    }
    
}
