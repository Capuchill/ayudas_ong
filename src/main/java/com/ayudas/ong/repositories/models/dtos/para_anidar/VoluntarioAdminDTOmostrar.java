package com.ayudas.ong.repositories.models.dtos.para_anidar;

import com.ayudas.ong.repositories.models.dtos.PersonaDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter @Setter
public class VoluntarioAdminDTOmostrar extends PersonaDTO {

    private String tipo;
    private String sede;

    public VoluntarioAdminDTOmostrar() {
        super(); // Llama al constructor de la clase padre si es necesario
    }
}
