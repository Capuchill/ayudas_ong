package com.ayudas.ong.repositories.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Socios")
public class Socio extends Persona {

    private Long cuentaBancaria;

    @ManyToOne
    @JoinColumn(
        name = "sede_id"
    )
    private Sede sede;

    @OneToMany(mappedBy = "socio")
    private List<Ingreso> ingresos;
    
    public Socio(long cedula, String p_nombre, String s_nombre, String p_apellido, String s_apellido, Rol rol, String email, String passWord) {
        super(cedula, p_nombre, s_nombre, p_apellido, s_apellido, rol, email, passWord);
    }
}
