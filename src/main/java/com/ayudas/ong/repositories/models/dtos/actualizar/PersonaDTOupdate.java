package com.ayudas.ong.repositories.models.dtos.actualizar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class PersonaDTOupdate {

    private String p_nombre;

    private String s_nombre;

    private String p_apellido;
    
    private String s_apellido;

    private String email;

}
