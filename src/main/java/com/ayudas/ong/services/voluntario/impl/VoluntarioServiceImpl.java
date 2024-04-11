package com.ayudas.ong.services.voluntario.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ayudas.ong.components.converters.VoluntarioConvert;
import com.ayudas.ong.repositories.VoluntarioRepository;
import com.ayudas.ong.repositories.entities.Sede;
import com.ayudas.ong.repositories.entities.Rol;
import com.ayudas.ong.repositories.entities.Voluntario;
import com.ayudas.ong.repositories.enums.TipoVoluntario;
import com.ayudas.ong.repositories.models.dtos.VoluntarioAdminDTO;
import com.ayudas.ong.repositories.models.dtos.VoluntarioDTO;
import com.ayudas.ong.repositories.models.dtos.actualizar.VoluntarioAdminDTOupdate;
import com.ayudas.ong.repositories.models.dtos.actualizar.VoluntarioDTOupdate;
import com.ayudas.ong.repositories.models.dtos.crear.VoluntarioDTOcrear;
import com.ayudas.ong.services.sede.SedeServicesPriv;
import com.ayudas.ong.services.voluntario.VoluntarioServices;
import com.ayudas.ong.util.exceptions.data_access.ManagerAccessExcp;
import com.ayudas.ong.util.exceptions.data_access.ManagerAccessExcp;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class VoluntarioServiceImpl implements VoluntarioServices {

    private final VoluntarioRepository voluntarioRepository;
    private final VoluntarioConvert voluntarioConvert;

    private final SedeServicesPriv sedeServicesPriv;

    @Override
    public List<VoluntarioAdminDTO> findAllAdministrativos(TipoVoluntario tipo) {
        return voluntarioRepository.findByTipo(tipo)
                .stream().map(
                        voluntario -> voluntarioConvert.VoluntarioAdminToDTO(voluntario))
                .toList();
    }

    @Override
    public List<VoluntarioDTO> findAllSanitarios(TipoVoluntario tipo) {
        return voluntarioRepository.findByTipo(tipo)
                .stream().map(
                        voluntario -> voluntarioConvert.VoluntarioToDTO(voluntario))
                .toList();
    }

    public VoluntarioDTO saveSanitario(VoluntarioDTO socioDTO) {
        return voluntarioConvert.VoluntarioToDTO(
            voluntarioRepository.save(
                    voluntarioConvert.SocioDtoToEntity(socioDTO)
            ));
    }

    @Override
    public VoluntarioDTO crear(VoluntarioDTOcrear voluntarioDTOcrear) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
        /* Voluntario socio = voluntarioRepository.findByCedula(voluntarioDTOcrear.getCedula());

        if (socio != null) {
            throw new ManagerAccessExcp("Voluntario existente", new Throwable(" El voluntario que se intenta crear, ya existe"));
        } else {
            TipoVoluntario tipo = voluntarioDTOcrear.getTipo().toUpperCase();

            Rol rol = rolServiceImpPriv.findByNombre(socioDTOcrear.getRol());
            Sede sede = sedeServicesPriv.findByNombre(socioDTOcrear.getSede());

            if (sede == null) {
                throw new ManagerAccessExcp("Dato no encontrado",
                        new Throwable(" ( Sede ) " + socioDTOcrear.getSede() + " no se encuentra registrada"));
            }
            if (rol == null) {
                throw new ManagerAccessExcp("Dato no encontrado",
                        new Throwable(" ( Rol ) " + socioDTOcrear.getRol() + " no se encuentra registrada"));
            }

            System.out.println(sede.toString());

            return socioDTOConvert.socioToDTO(
                    socioRepository.save(socioDTOConvert.socioDtoCrearToEntity(socioDTOcrear, rol, sede)));
        } */
    }

    @Override
    public VoluntarioDTO save(VoluntarioDTO voluntarioDTO) {
        Voluntario voluntario = voluntarioRepository.findByCedula(voluntarioDTO.getCedula());
        voluntario.setSede(null);
        return voluntarioConvert.VoluntarioToDTO2(voluntarioRepository.save(voluntario));
    }

    @Override
    public void delete(Long cedula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public VoluntarioDTO findByEmail(String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByEmail'");
    }

    @Override
    public VoluntarioDTO findByCedula(long cedula) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByCedula'");
    }

    @Override
    public VoluntarioAdminDTO updateAdmin(VoluntarioAdminDTOupdate voluntarioAdminDTOupdate, long cedula) throws ManagerAccessExcp {
        if (TipoVoluntario.exists(voluntarioAdminDTOupdate.getTipo())) {
            Sede sede = sedeServicesPriv.findByNombre(voluntarioAdminDTOupdate.getSede());

            if (sede == null) {
                throw new ManagerAccessExcp("Sede inexistente",
                        new Throwable("La sede " + voluntarioAdminDTOupdate.getSede() + " no existe"));
            }

            Voluntario voluntario = voluntarioRepository.findByCedula(cedula);
            return voluntarioConvert.entityToVoluntarioAdminDTO(
                    voluntarioRepository.save(
                            voluntarioConvert.dtoAdminUpdateToEntity(voluntario, voluntarioAdminDTOupdate, sede,
                                    TipoVoluntario.valueOf(voluntarioAdminDTOupdate.getTipo()))));
        } else {
            throw new ManagerAccessExcp("Tipo inexistente",
                    new Throwable(voluntarioAdminDTOupdate.getTipo() + " no existe"));
        }
    }

    @Override
    public VoluntarioDTO updateSanitario(VoluntarioDTOupdate voluntarioDTOupdate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSanitario'");
    }

}
