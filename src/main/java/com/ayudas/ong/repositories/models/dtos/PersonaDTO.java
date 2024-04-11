package com.ayudas.ong.repositories.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class PersonaDTO {

    private long cedula;

    private String p_nombre;

    private String s_nombre;

    private String p_apellido;
    
    private String s_apellido;

    private RolDTO rol;

    private String email;

    public PersonaDTO(long cedula, String p_nombre, String s_nombre, String p_apellido, String s_apellido,
            String email, RolDTO rol) {
        this.cedula = cedula;
        this.p_nombre = p_nombre;
        this.s_nombre = s_nombre;
        this.p_apellido = p_apellido;
        this.s_apellido = s_apellido;
        this.email = email;
        this.rol = rol;
    }

}
