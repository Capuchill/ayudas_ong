package com.ayudas.ong.repositories.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.ayudas.ong.repositories.enums.TipoMaterial;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "Envios")
public class Envio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private TipoMaterial tipo;

    @Temporal(TemporalType.DATE)
    private LocalDate fechaEnvio;

    @ManyToOne
    @JoinColumn(
        name = "refugio_id"
    )
    private Refugio refugio;

    @OneToMany(mappedBy = "envio")
    private List<Item> itemsEnvio;

    @ManyToMany
    @JoinTable(
        name = "envios_sedes",
        joinColumns = @JoinColumn(
            name = "envio_id"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "sede_id"
        )
    )
    private List<Sede> sedes;
    
}
