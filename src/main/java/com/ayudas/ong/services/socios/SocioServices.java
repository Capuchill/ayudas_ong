package com.ayudas.ong.services.socios;

import java.util.List;

import com.ayudas.ong.repositories.models.dtos.IngresoDTO;
import com.ayudas.ong.repositories.models.dtos.SocioDTO;
import com.ayudas.ong.repositories.models.dtos.actualizar.SocioDTOupdate;
import com.ayudas.ong.repositories.models.dtos.crear.SocioDTOcrear;

public interface SocioServices {

    List<SocioDTO> findAll();

    SocioDTO crear(final SocioDTOcrear socioDTOcrear);

    SocioDTO save(final SocioDTO socioDTO);

    SocioDTO update(final Long cedula, final SocioDTOupdate socioDTOupdate);

    void delete(final Long cedula);

    SocioDTO findByEmail(final String email);

    SocioDTO findByCedula(long cedula);

    List<IngresoDTO> buscarSocioByTipoCuenta(String tipo);
    
}
