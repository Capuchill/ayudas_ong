package com.ayudas.ong.services.rol;

import java.util.List;

import com.ayudas.ong.repositories.models.dtos.RolDTO;
import com.ayudas.ong.repositories.models.dtos.crear.RolDTOcrear;

public interface RolServices {

    List<RolDTO> findAll();

    RolDTO findById(final Long id);

    RolDTO crear(final RolDTOcrear rolDTOcrear);

    RolDTO save(final RolDTO rolDTO);

    RolDTO update(final Long id, final RolDTO rolDTO);

    void delete(final Long id);

    RolDTO findByNombre(final String nombre);

}
