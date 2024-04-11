package com.ayudas.ong.services.sede.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ayudas.ong.components.converters.SedeConverter;
import com.ayudas.ong.components.converters.VoluntarioConvert;
import com.ayudas.ong.repositories.SedeRepository;
import com.ayudas.ong.repositories.entities.Ciudad;
import com.ayudas.ong.repositories.entities.Director;
import com.ayudas.ong.repositories.entities.Sede;
import com.ayudas.ong.repositories.models.dtos.SedeDTO;
import com.ayudas.ong.repositories.models.dtos.actualizar.SedeDTOupdate;
import com.ayudas.ong.repositories.models.dtos.crear.SedeDTOcrear;
import com.ayudas.ong.repositories.models.dtos.para_anidar.SedeDTOmostrar;
import com.ayudas.ong.services.ciudad.CiudadServicePriv;
import com.ayudas.ong.services.director.imp.DirectorServicePriv;
import com.ayudas.ong.services.sede.SedeServices;
import com.ayudas.ong.services.voluntario.VoluntarioServices;
import com.ayudas.ong.util.exceptions.data_access.ManagerAccessExcp;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SedeServiceImpl implements SedeServices {

    private final SedeRepository sedeRepository;
    private final SedeConverter sedeConverter;
    private final VoluntarioServices voluntarioServices;
    private final VoluntarioConvert voluntarioConvert;
    // Servicios Privados
    private final DirectorServicePriv directorServicePriv;
    private final CiudadServicePriv ciudadServicePriv;

    @Transactional(readOnly = true)
    @Override
    public List<SedeDTOmostrar> findAll() {
        List<SedeDTOmostrar> sedes = new ArrayList<>();
        sedeRepository.findAll()
                .forEach(sede -> sedes.add(sedeConverter.entityToDtoMostrar(sede)));

        return sedes;
    }

    @Transactional
    @Override
    public SedeDTO crear(final SedeDTOcrear sedeDTOcrear) throws ManagerAccessExcp {
        Sede sede = sedeRepository.findByNombre(sedeDTOcrear.getNombre());
        if (sede != null) {
            throw new ManagerAccessExcp("Existencia",
                    new Throwable(" La sede " + sedeDTOcrear.getNombre() + " ya existe."));
        } else {
            Director director = directorServicePriv.findByCedula(sedeDTOcrear.getDirector());
            Ciudad ciudad = ciudadServicePriv.findByNombre(sedeDTOcrear.getCiudad());
            if (director == null) {
                throw new ManagerAccessExcp("Existencia",
                        new Throwable(" El director con cédula " + sedeDTOcrear.getDirector() + " no existe."));
            } else if (ciudad == null) {
                throw new ManagerAccessExcp("Existencia",
                        new Throwable(" La ciudad " + sedeDTOcrear.getCiudad() + " no existe."));
            }

            else {
                sede = sedeConverter.dtoCrearToEntity(sedeDTOcrear, director, ciudad);
                return sedeConverter.entityToDto(sedeRepository.save(sede));
            }
        }
    }

    @Transactional
    @Override
    public SedeDTO save(final SedeDTO sedeDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Transactional
    @Override
    public SedeDTOmostrar updateInfoBasic(final String nombre, final SedeDTOupdate sedeDTOupdate) {

        Sede sede = sedeRepository.findByNombre(nombre);
        
        if (sede == null) {
            throw new ManagerAccessExcp("Existencia",
                    new Throwable(" La sede " + nombre + " no existe."));
        } else {
            Director director = directorServicePriv.findByCedula(sedeDTOupdate.getDirector());
            Ciudad ciudad = ciudadServicePriv.findByNombre(sedeDTOupdate.getCiudad());
            if (director == null) {
                throw new ManagerAccessExcp("Existencia",
                        new Throwable(" El director con cédula " + sedeDTOupdate.getDirector() + " no existe."));
            } else if (ciudad == null) {
                throw new ManagerAccessExcp("Existencia",
                        new Throwable(" La ciudad " + sedeDTOupdate.getCiudad() + " no existe."));
            }

            else {
                sede = sedeConverter.updateEntityDtoUpdate(sede, sedeDTOupdate, director, ciudad);
                return sedeConverter.entityToDtoMostrar(sedeRepository.save(sede));
            }
        }

    }

    @Transactional
    @Override
    public void delete(final String nombre) {
        Sede sede = sedeRepository.findByNombre(nombre);

        sede.getVoluntarios().forEach(
            voluntario -> {
                voluntarioServices.save(voluntarioConvert.VoluntarioToDTO(voluntario));
            }
        );;
        sede = null;
        sede = sedeRepository.findByNombre(nombre);

        sedeRepository.delete(sede);
    }

    @Transactional(readOnly = true)
    @Override
    public SedeDTO findByNombre(final String nombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByNombre'");
    }

}
