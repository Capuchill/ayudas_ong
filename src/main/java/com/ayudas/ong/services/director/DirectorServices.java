package com.ayudas.ong.services.director;

import java.util.List;

import com.ayudas.ong.repositories.models.dtos.DirectorDTO;
import com.ayudas.ong.repositories.models.dtos.actualizar.DirectorDTOupdate;
import com.ayudas.ong.repositories.models.dtos.crear.DirectorDTOcrear;

public interface DirectorServices {
    
    List<DirectorDTO> findAll();

    DirectorDTO crear(final DirectorDTOcrear directorDTOcrear);

    DirectorDTO save(final DirectorDTO directorDTO);

    DirectorDTO update(final Long cedula, final DirectorDTOupdate directorDTOupdate);

    void delete(final Long cedula);

    DirectorDTO findByEmail(final String email);

    DirectorDTO findByCedula(long cedula);

}
