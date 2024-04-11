package com.ayudas.ong.repositories.models.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CiudadDTO implements Serializable {
    
    private String nombre;
    
}
