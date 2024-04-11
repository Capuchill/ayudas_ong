package com.ayudas.ong.services.director.imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayudas.ong.repositories.DirectorRepository;
import com.ayudas.ong.repositories.models.dtos.DirectorDTO;
import com.ayudas.ong.repositories.models.dtos.actualizar.DirectorDTOupdate;
import com.ayudas.ong.repositories.models.dtos.crear.DirectorDTOcrear;
import com.ayudas.ong.services.director.DirectorServices;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DirectorServiceImp implements DirectorServices {

    public DirectorRepository directorRepository;

    @Transactional(readOnly = true)
    @Override
    public List<DirectorDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Transactional
    @Override
    public DirectorDTO crear(DirectorDTOcrear directorDTOcrear) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Transactional
    @Override
    public DirectorDTO save(DirectorDTO directorDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Transactional
    @Override
    public DirectorDTO update(Long cedula, DirectorDTOupdate directorDTOupdate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Transactional
    @Override
    public void delete(Long cedula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Transactional(readOnly = true)
    @Override
    public DirectorDTO findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }

    @Transactional(readOnly = true)
    @Override
    public DirectorDTO findByCedula(long cedula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCedula'");
    }

    
}
