package com.ayudas.ong.repositories.entities;

import com.ayudas.ong.repositories.enums.Disponibilidad;
import com.ayudas.ong.repositories.enums.TipoVoluntario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "Voluntarios")
public class Voluntario extends Persona {

    @Enumerated(EnumType.STRING)
    private TipoVoluntario tipo;

    @ManyToOne
    @JoinColumn(
        name = "profesion_id"
    )
    private Profesion profesion;

    @Enumerated(EnumType.STRING)
    private Disponibilidad disponibilidad;

    private int cantParticipacion;

    @ManyToOne
    @JoinColumn(
        name = "sede_id"
    )
    private Sede sede;
    
}
