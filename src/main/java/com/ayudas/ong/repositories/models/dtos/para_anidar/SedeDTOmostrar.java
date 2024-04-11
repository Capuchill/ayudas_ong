package com.ayudas.ong.repositories.models.dtos.para_anidar;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SedeDTOmostrar implements Serializable {

    private String nombre;

    private List<String> socios;

    private String ciudad;

    private List<String> voluntarios;

    private String direccion;

    private String director;
    
}
