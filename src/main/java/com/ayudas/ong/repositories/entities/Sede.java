package com.ayudas.ong.repositories.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "Sedes")
public class Sede implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "sede")
    private List<Socio> socios;

    @ManyToOne
    @JoinColumn(
        name = "ciudad_id"
    )
    private Ciudad ciudad;

    @OneToMany(mappedBy = "sede")
    private List<Voluntario> voluntarios;

    private String direccion;

    @OneToOne
    @JoinColumn(
        name = "director_id"
    )
    private Director director;

    @ManyToMany(mappedBy = "sedes")
    private List<Envio> enviosAyudas;
    
}
