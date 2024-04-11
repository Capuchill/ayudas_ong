package com.ayudas.ong.services.rol.imp;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayudas.ong.components.converters.RolDTOConvert;
import com.ayudas.ong.repositories.RolRepository;
import com.ayudas.ong.repositories.enums.Roles;
import com.ayudas.ong.repositories.models.dtos.RolDTO;
import com.ayudas.ong.repositories.models.dtos.crear.RolDTOcrear;
import com.ayudas.ong.services.rol.RolServices;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RolServiceImp implements RolServices {

    private final RolRepository rolRepository;
    private final RolDTOConvert rolDTOConvert;

    @Transactional(readOnly = true)
    @Override
    public List<RolDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
    @Transactional(readOnly = true)
    @Override
    public RolDTO findById(final Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    @Transactional
    @Override
    public RolDTO crear(final RolDTOcrear rolDTOcrear) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }
    @Transactional
    @Override
    public RolDTO save(final RolDTO rolDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
    @Transactional
    @Override
    public RolDTO update(final Long id, RolDTO rolDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Transactional
    @Override
    public void delete(final Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Transactional(readOnly = true)
    @Override
    public RolDTO findByNombre(final String nombre) {
        return rolDTOConvert.RolToDTO(rolRepository.findByNombre(Roles.valueOf(nombre)));
    }
    
}
