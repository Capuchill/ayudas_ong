package com.ayudas.ong.repositories.models.dtos.actualizar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class VoluntarioDTOupdate  {

    private String tipo;

    private String profesion;

    private String disponibilidad;

    private int cantParticipacion;

    private String sede;

}
