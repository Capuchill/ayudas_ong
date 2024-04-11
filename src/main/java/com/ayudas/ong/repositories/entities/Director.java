package com.ayudas.ong.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Directores")
public class Director extends Persona {

    @OneToOne(mappedBy = "director")
    private Sede sede;

    public Director(long cedula, String p_nombre, String s_nombre, String p_apellido, String s_apellido, Rol rol, String email, String passWord) {
        super(cedula, p_nombre, s_nombre, p_apellido, s_apellido, rol, email, passWord);
    }

}
