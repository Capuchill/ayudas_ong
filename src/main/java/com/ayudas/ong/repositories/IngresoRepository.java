package com.ayudas.ong.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ayudas.ong.repositories.entities.Ingreso;
import java.util.List;
import com.ayudas.ong.repositories.enums.TiposCuenta;


public interface IngresoRepository extends CrudRepository<Ingreso, Long> {

    List<Ingreso> findByTipoCuenta(TiposCuenta tipoCuenta);

    Ingreso findByCodigo(String codigo);
    
}
