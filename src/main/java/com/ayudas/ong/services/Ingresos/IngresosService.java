package com.ayudas.ong.services.Ingresos;

import java.util.List;

import com.ayudas.ong.repositories.models.dtos.IngresoDTO;

public interface IngresosService {

    List<IngresoDTO> findAll();

    List<IngresoDTO> findByTipoCuenta(String tipoCuenta);

    IngresoDTO findByCodigo(String codigo);

    IngresoDTO crear(final IngresoDTO socioDTOcrear);

    IngresoDTO save(final IngresoDTO socioDTO);

    IngresoDTO update(final String codigo, final IngresoDTO socioDTO);

    void delete(final Long cedula);
    
}
