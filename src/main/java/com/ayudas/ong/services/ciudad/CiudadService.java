package com.ayudas.ong.services.ciudad;

import java.util.List;

import com.ayudas.ong.repositories.models.dtos.CiudadDTO;

public interface CiudadService {

    List<CiudadDTO> findAll();

    CiudadDTO crear(final CiudadDTO ciudadDTO);

    CiudadDTO save(final CiudadDTO sedeDTO);

    CiudadDTO update(final Long id, final CiudadDTO sedeDTO);

    void delete(final Long id);

    CiudadDTO findByNombre(final String nombre);
    
}
