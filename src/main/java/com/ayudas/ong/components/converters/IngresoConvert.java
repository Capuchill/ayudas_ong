package com.ayudas.ong.components.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ayudas.ong.repositories.entities.Ingreso;
import com.ayudas.ong.repositories.models.dtos.IngresoDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class IngresoConvert {

    @Autowired
    private final ModelMapper model;
    private final SocioDTOConvert socioDTOConvert;

    public IngresoDTO entityToDto(Ingreso ingreso) {
        IngresoDTO ingresoDTO = model.map(ingreso, IngresoDTO.class);
        ingresoDTO.setSocio(
                socioDTOConvert.entityToDtoIngreso(ingreso.getSocio()));
        
        ingresoDTO.getSocio().setSede(ingreso.getSocio().getSede().getNombre());
                

        return ingresoDTO;
    }

}
