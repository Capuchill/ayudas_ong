package com.ayudas.ong.repositories.models.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import com.ayudas.ong.repositories.enums.TiposCuenta;
import com.ayudas.ong.repositories.models.dtos.para_anidar.SocioDTOingreso;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class IngresoDTO implements Serializable {

    private SocioDTOingreso socio;

    private TiposCuenta tipoCuenta;

    private double cuota;

    private LocalDate fechaPago;
}
