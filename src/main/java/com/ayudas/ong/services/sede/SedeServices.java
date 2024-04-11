package com.ayudas.ong.services.sede;

import java.util.List;

import com.ayudas.ong.repositories.models.dtos.SedeDTO;
import com.ayudas.ong.repositories.models.dtos.actualizar.SedeDTOupdate;
import com.ayudas.ong.repositories.models.dtos.crear.SedeDTOcrear;
import com.ayudas.ong.repositories.models.dtos.para_anidar.SedeDTOmostrar;

public interface SedeServices {

    List<SedeDTOmostrar> findAll();

    SedeDTO crear(final SedeDTOcrear sedeDTOcrear);

    SedeDTO save(final SedeDTO sedeDTO);

    SedeDTOmostrar updateInfoBasic(final String nombre, final SedeDTOupdate sedeDTOupdate);

    void delete(final String nombre);

    SedeDTO findByNombre(final String nombre);

}
