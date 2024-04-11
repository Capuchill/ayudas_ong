package com.ayudas.ong.services.Ingresos;

import java.util.List;

import com.ayudas.ong.repositories.entities.Ingreso;

public interface IngresosServicePriv {

    List<Ingreso> findAll();

    List<Ingreso> findByTipoCuenta(String tipoCuenta);

    Ingreso findByCodigo(String codigo);
    
}
