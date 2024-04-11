package com.ayudas.ong.repositories.entities;

import java.io.Serializable;

import com.ayudas.ong.repositories.enums.Roles;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Roles")
public class Rol implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRol;

    @Enumerated(EnumType.STRING)
    private Roles nombre;
    
    private String descripcion;

    public Rol(Roles nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
}
