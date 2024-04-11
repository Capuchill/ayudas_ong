package com.ayudas.ong.repositories.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter @Setter
public class VoluntarioAdminDTO extends PersonaDTO{

    private String tipo;
    private String sede;

    public VoluntarioAdminDTO() {
        super(); // Llama al constructor de la clase padre si es necesario
    }
}
