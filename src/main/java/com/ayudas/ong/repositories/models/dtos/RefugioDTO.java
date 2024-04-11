package com.ayudas.ong.repositories.models.dtos;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RefugioDTO implements Serializable {

    private String nombre;

    private String direccion;

    private CiudadDTO ciudad;

    private List<EnvioDTO> envios;
    
}
