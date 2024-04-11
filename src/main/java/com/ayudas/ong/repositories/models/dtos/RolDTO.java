package com.ayudas.ong.repositories.models.dtos;

import java.io.Serializable;

import com.ayudas.ong.repositories.enums.Roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class RolDTO implements Serializable {
    
    private Roles nombre;
    
    private String descripcion;
        
}
