package com.ayudas.ong.services.Ingresos.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayudas.ong.components.converters.IngresoConvert;
import com.ayudas.ong.repositories.IngresoRepository;
import com.ayudas.ong.repositories.enums.TiposCuenta;
import com.ayudas.ong.repositories.models.dtos.IngresoDTO;
import com.ayudas.ong.services.Ingresos.IngresosService;
import com.ayudas.ong.util.exceptions.data_access.ManagerAccessExcp;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class IngresosServiceImp implements IngresosService {

    private final IngresoRepository ingresoRepository;
    private final IngresoConvert ingresoConvert;

    @Transactional(readOnly = true)
    @Override
    public List<IngresoDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Transactional(readOnly = true)
    @Override
    public List<IngresoDTO> findByTipoCuenta(String tipoCuenta) throws ManagerAccessExcp {
        if (TiposCuenta.exists(tipoCuenta)) {
            List<IngresoDTO> lIngresoDTOs = new ArrayList<>();
            ingresoRepository.findByTipoCuenta(TiposCuenta.valueOf(tipoCuenta.toUpperCase()))
                    .forEach(ingreso -> lIngresoDTOs.add(ingresoConvert.entityToDto(ingreso)));

            return lIngresoDTOs;
        }
        else {
            throw new ManagerAccessExcp("No encontrado", new Throwable(" El tipo de cuenta " + tipoCuenta + " no está disponible"));
        }
    }

    @Transactional(readOnly = true)
    @Override
    public IngresoDTO findByCodigo(String codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCodigo'");
    }

    @Override
    public IngresoDTO crear(IngresoDTO socioDTOcrear) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crear'");
    }

    @Override
    public IngresoDTO save(IngresoDTO socioDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public IngresoDTO update(String codigo, IngresoDTO socioDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long cedula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
