package com.ayudas.ong.repositories.models.dtos;

import com.ayudas.ong.repositories.enums.Disponibilidad;
import com.ayudas.ong.repositories.enums.TipoVoluntario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class VoluntarioDTO extends PersonaDTO {

    private TipoVoluntario tipo;

    private ProfesionDTO profesion;

    private Disponibilidad disponibilidad;

    private int cantParticipacion;

    private String sede;
    
}
