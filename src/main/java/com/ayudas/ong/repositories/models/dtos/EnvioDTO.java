package com.ayudas.ong.repositories.models.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.ayudas.ong.repositories.enums.TipoMaterial;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class EnvioDTO implements Serializable {

    private TipoMaterial tipo;

    private LocalDate fechaEnvio;

    private RefugioDTO refugio;
    private List<ItemDTO> itemsEnvio;

    private List<SedeDTO> sedes;
    
}
