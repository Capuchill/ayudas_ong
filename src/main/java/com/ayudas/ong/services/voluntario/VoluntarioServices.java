package com.ayudas.ong.services.voluntario;

import java.util.List;

import com.ayudas.ong.repositories.enums.TipoVoluntario;
import com.ayudas.ong.repositories.models.dtos.VoluntarioAdminDTO;
import com.ayudas.ong.repositories.models.dtos.VoluntarioDTO;
import com.ayudas.ong.repositories.models.dtos.actualizar.VoluntarioAdminDTOupdate;
import com.ayudas.ong.repositories.models.dtos.actualizar.VoluntarioDTOupdate;
import com.ayudas.ong.repositories.models.dtos.crear.VoluntarioDTOcrear;

public interface VoluntarioServices {

    
    List<VoluntarioAdminDTO> findAllAdministrativos(TipoVoluntario tipo);

    List<VoluntarioDTO> findAllSanitarios(TipoVoluntario tipo);

    VoluntarioDTO crear(final VoluntarioDTOcrear VoluntarioDTOcrear);

    VoluntarioDTO save(final VoluntarioDTO VoluntarioDTO);

    VoluntarioAdminDTO updateAdmin(final VoluntarioAdminDTOupdate voluntarioAdminDTOupdate, final long cedula);

    VoluntarioDTO updateSanitario(final VoluntarioDTOupdate voluntarioDTOupdate);

    void delete(final Long cedula);

    VoluntarioDTO findByEmail(final String email);

    VoluntarioDTO findByCedula(long cedula);

}
