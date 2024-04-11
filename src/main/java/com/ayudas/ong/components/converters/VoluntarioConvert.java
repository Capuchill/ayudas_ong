package com.ayudas.ong.components.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ayudas.ong.repositories.entities.Sede;
import com.ayudas.ong.repositories.entities.Profesion;
import com.ayudas.ong.repositories.entities.Sede;
import com.ayudas.ong.repositories.entities.Voluntario;
import com.ayudas.ong.repositories.enums.Disponibilidad;
import com.ayudas.ong.repositories.enums.TipoVoluntario;
import com.ayudas.ong.repositories.enums.TipoVoluntario;
import com.ayudas.ong.repositories.models.dtos.VoluntarioAdminDTO;
import com.ayudas.ong.repositories.models.dtos.VoluntarioDTO;
import com.ayudas.ong.repositories.models.dtos.crear.VoluntarioDTOcrear;
import com.ayudas.ong.repositories.models.dtos.actualizar.VoluntarioAdminDTOupdate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class VoluntarioConvert {

    private final ModelMapper model;

    public VoluntarioAdminDTO VoluntarioAdminToDTO(Voluntario socio) {
        VoluntarioAdminDTO socioDTO = model.map(socio, VoluntarioAdminDTO.class);
        socioDTO.setSede(socio.getSede().getNombre());
        return socioDTO;
    }

    public VoluntarioDTO VoluntarioToDTO(Voluntario socio) {
        VoluntarioDTO socioDTO = model.map(socio, VoluntarioDTO.class);
        socioDTO.setSede(socio.getSede().getNombre());
        return socioDTO;
    }

    public Voluntario SocioDtoToEntity(VoluntarioDTO socioDTO) {
        Voluntario socio = model.map(socioDTO, Voluntario.class);
        return socio;
    }

    public Voluntario VoluntarioSanitarioDtoCrearToEntity
    (VoluntarioDTOcrear socioDTOcrear, 
    TipoVoluntario rol, 
    Sede sede, 
    Disponibilidad disponibilidad,
    Profesion profesion){

        Voluntario socio = model.map(socioDTOcrear, Voluntario.class);
        socio.setTipo(rol);
        socio.setSede(sede);
        socio.setDisponibilidad(disponibilidad);
        socio.setProfesion(profesion);

        return socio;
    }

    public Voluntario VoluntarioAdminDtoCrearToEntity
    (VoluntarioDTOcrear socioDTOcrear, 
    TipoVoluntario rol, 
    Sede sede){

        Voluntario socio = model.map(socioDTOcrear, Voluntario.class);
        socio.setTipo(rol);
        socio.setSede(sede);

        return socio;
    }



    public VoluntarioDTO VoluntarioToDTO2(Voluntario socio) {
        VoluntarioDTO socioDTO = model.map(socio, VoluntarioDTO.class);
        return socioDTO;
    }

    public Voluntario dtoToEntity(VoluntarioDTO voluntarioDTO) {
        Voluntario voluntario = model.map(voluntarioDTO, Voluntario.class);

        return voluntario;
    }

    public Voluntario dtoAdminUpdateToEntity(Voluntario voluntario, VoluntarioAdminDTOupdate voluntarioAdminDTOupdate,
            Sede sede, TipoVoluntario tipo) {
        voluntario.setP_nombre(voluntarioAdminDTOupdate.getP_nombre());
        voluntario.setS_nombre(voluntarioAdminDTOupdate.getS_nombre());
        voluntario.setP_apellido(voluntarioAdminDTOupdate.getP_apellido());
        voluntario.setS_apellido(voluntarioAdminDTOupdate.getS_apellido());
        voluntario.setEmail(voluntarioAdminDTOupdate.getEmail());
        voluntario.setTipo(tipo);
        voluntario.setSede(sede);

        return voluntario;
    }

    public VoluntarioAdminDTO entityToVoluntarioAdminDTO(Voluntario voluntario) {
        VoluntarioAdminDTO voluntarioAdminDTO = model.map(voluntario, VoluntarioAdminDTO.class);
        return voluntarioAdminDTO;
    }

}
