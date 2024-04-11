package com.ayudas.ong.repositories.models.dtos;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SedeDTO implements Serializable {

    private String nombre;

    private List<SocioDTO> socios;

    private String ciudad;

    private List<VoluntarioDTO> voluntarios;

    private String direccion;

    private String director;

    private List<EnvioDTO> enviosAyudas;
    
}
