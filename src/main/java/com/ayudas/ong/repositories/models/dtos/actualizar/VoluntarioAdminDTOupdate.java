package com.ayudas.ong.repositories.models.dtos.actualizar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@AllArgsConstructor
@Getter @Setter
public class VoluntarioAdminDTOupdate extends PersonaDTOupdate {

    private String tipo;
    private String sede;

    public VoluntarioAdminDTOupdate() {
        super(); // Llama al constructor de la clase padre si es necesario
    }
}
