package com.ayudas.ong.repositories.models.dtos.crear;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class SocioDTOcrear extends PersonaDTOcrear {

    private Long cuentaBancaria;

    private String sede;

}
