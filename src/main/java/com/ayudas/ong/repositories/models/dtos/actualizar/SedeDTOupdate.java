package com.ayudas.ong.repositories.models.dtos.actualizar;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class SedeDTOupdate implements Serializable {

    private String nombre;

    private String ciudad;

    private String direccion;

    private long director;
    
}
