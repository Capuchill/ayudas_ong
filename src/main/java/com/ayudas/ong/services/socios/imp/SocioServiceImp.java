package com.ayudas.ong.services.socios.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayudas.ong.components.converters.SocioDTOConvert;
import com.ayudas.ong.repositories.SocioRepository;
import com.ayudas.ong.repositories.entities.Rol;
import com.ayudas.ong.repositories.entities.Sede;
import com.ayudas.ong.repositories.entities.Socio;
import com.ayudas.ong.repositories.models.dtos.IngresoDTO;
import com.ayudas.ong.repositories.models.dtos.SocioDTO;
import com.ayudas.ong.repositories.models.dtos.actualizar.SocioDTOupdate;
import com.ayudas.ong.repositories.models.dtos.crear.SocioDTOcrear;
import com.ayudas.ong.services.Ingresos.IngresosService;
import com.ayudas.ong.services.rol.imp.RolServiceImpPriv;
import com.ayudas.ong.services.sede.SedeServicesPriv;
import com.ayudas.ong.services.socios.SocioServices;
import com.ayudas.ong.util.exceptions.data_access.ManagerAccessExcp;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SocioServiceImp implements SocioServices {

    private final SocioRepository socioRepository;
    private final SocioDTOConvert socioDTOConvert;
    private final IngresosService ingresosService;
    // Servicios privados
    private final RolServiceImpPriv rolServiceImpPriv;
    private final SedeServicesPriv sedeServicesPriv;
    private final SocioServicePrivImp socioServicePrivImp;

    @Transactional(readOnly = true)
    @Override
    public List<SocioDTO> findAll() {
        List<SocioDTO> sDtos = new ArrayList<>();
        for (Socio socio : socioRepository.findAll()) {
            sDtos.add(socioDTOConvert.socioToDTO(socio));
        }
        return sDtos;
    }

    @Transactional
    @Override
    public SocioDTO save(SocioDTO socioDTO) {
        return socioDTOConvert.socioToDTO(
                socioRepository.save(
                        socioDTOConvert.SocioDtoToEntity(socioDTO)));
    }

    @Transactional
    @Override
    public SocioDTO update(Long cedula, SocioDTOupdate socioDTOupdate) throws ManagerAccessExcp {
        Socio socio = socioServicePrivImp.findByCedula(cedula);

        if(socio == null) {
            throw new ManagerAccessExcp("Socio no existente", new Throwable(" El socio que se intenta actualizar, no existe"));
        }
        else {
            socio = socioDTOConvert.socioCargarDataDtoUpdate(socio, socioDTOupdate);
            return socioDTOConvert.socioToDTO(socioRepository.save(socio));
        }

    }

    @Transactional
    @Override
    public void delete(Long cedula) {
        Socio socio = socioServicePrivImp.findByCedula(cedula);

        if (socio == null) {
            throw new ManagerAccessExcp("Socio no encontrado", new Throwable(" El socio que se intenta eliminar, no existe"));
        } else {
            socioRepository.delete(socio);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public SocioDTO findByEmail(String email) {
        Socio socio = socioServicePrivImp.findByEmail(email);

        if (socio == null) {
            throw new ManagerAccessExcp("Socio no encontrado", new Throwable(" El socio que se intenta buscar, no se encuentra"));
        } else {
            return socioDTOConvert.socioToDTO(socio);
        }
    }

    @Transactional
    @Override
    public SocioDTO crear(SocioDTOcrear socioDTOcrear) throws ManagerAccessExcp {

        Socio socio = socioServicePrivImp.findByCedula(socioDTOcrear.getCedula());

        if (socio != null) {
            throw new ManagerAccessExcp("Socio existente", new Throwable(" El socio que se intenta crear, ya existe"));
        } else {
            socioDTOcrear.setRol(socioDTOcrear.getRol().toUpperCase());

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
        }

    }

    @Transactional(readOnly = true)
    @Override
    public SocioDTO findByCedula(long cedula) {
        return socioDTOConvert.socioToDTO(
                socioRepository.findByCedula(cedula));
    }

    public List<IngresoDTO> buscarSocioByTipoCuenta(String tipo) {
        return ingresosService.findByTipoCuenta(tipo);
    }

}
