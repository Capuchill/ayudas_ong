package com.ayudas.ong.repositories.models.dtos.actualizar;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class DirectorDTOupdate {

    private String p_nombre;

    private String s_nombre;

    private String p_apellido;
    
    private String s_apellido;

    private String rol;

    private String email;

    private String sede;

}
