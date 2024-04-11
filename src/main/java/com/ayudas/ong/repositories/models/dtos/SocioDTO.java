package com.ayudas.ong.repositories.models.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class SocioDTO extends PersonaDTO {

    private Long cuentaBancaria;

    private String sede;

    private List<IngresoDTO> ingresos;
}
