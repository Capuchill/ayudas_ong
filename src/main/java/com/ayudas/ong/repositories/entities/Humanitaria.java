package com.ayudas.ong.repositories.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@DiscriminatorValue("Humanitaria")
public class Humanitaria extends Ayuda {
    
    @OneToOne
    @JoinColumn(
        name = "voluntario_id"
    )
    private Voluntario voluntario;

}
