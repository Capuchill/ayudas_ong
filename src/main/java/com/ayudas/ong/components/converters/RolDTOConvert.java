package com.ayudas.ong.components.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ayudas.ong.repositories.entities.Rol;
import com.ayudas.ong.repositories.models.dtos.RolDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class RolDTOConvert {
    
    @Autowired
    private final ModelMapper model;

    public RolDTO RolToDTO(Rol rol) {
        RolDTO rolDTO = model.map(rol, RolDTO.class);

        return rolDTO;
    }

    public Rol RolDtoToEntity(RolDTO rolDTO) {
        Rol rol = model.map(rolDTO, Rol.class);

        return rol;
    }

}
