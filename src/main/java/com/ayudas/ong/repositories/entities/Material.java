package com.ayudas.ong.repositories.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
@DiscriminatorValue("material_id")
public class Material extends Ayuda {
    
    @OneToOne
    @JoinColumn(
        name = "articulo_id"
    )
    private Articulo articulo;
    
}
