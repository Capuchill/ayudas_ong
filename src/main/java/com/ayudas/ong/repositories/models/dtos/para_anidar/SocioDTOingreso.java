package com.ayudas.ong.repositories.models.dtos.para_anidar;

import com.ayudas.ong.repositories.models.dtos.PersonaDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class SocioDTOingreso extends PersonaDTO {

    private Long cuentaBancaria;

    private String sede;

}
