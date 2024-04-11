package com.ayudas.ong.repositories.models.dtos.crear;

import com.ayudas.ong.repositories.enums.TipoVoluntario;
import com.ayudas.ong.repositories.models.dtos.PersonaDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class VoluntarioDTOcrear extends PersonaDTO{
    
    private String tipo;

    private String profesion;

    private String disponibilidad;

    private int cantParticipacion;

    private String sede;

}
