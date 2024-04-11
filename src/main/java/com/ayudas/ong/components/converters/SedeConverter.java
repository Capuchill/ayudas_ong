package com.ayudas.ong.components.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.ayudas.ong.repositories.entities.Ciudad;
import com.ayudas.ong.repositories.entities.Director;
import com.ayudas.ong.repositories.entities.Sede;
import com.ayudas.ong.repositories.models.dtos.SedeDTO;
import com.ayudas.ong.repositories.models.dtos.actualizar.SedeDTOupdate;
import com.ayudas.ong.repositories.models.dtos.crear.SedeDTOcrear;
import com.ayudas.ong.repositories.models.dtos.para_anidar.SedeDTOmostrar;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class SedeConverter {

    private final ModelMapper model;
    private final SocioDTOConvert socioDTOConvert;

    public SedeDTO entityToDto(Sede sede) {
        SedeDTO sedeDTO = model.map(sede, SedeDTO.class);
        sedeDTO.setCiudad(sede.getCiudad().getNombre());
        Director director = sede.getDirector();

        String nombre = director.getP_nombre().concat(" ")
                .concat(director.getS_nombre()).concat(" ")
                .concat(director.getP_apellido()).concat(" ")
                .concat(director.getS_apellido());

        sedeDTO.setDirector(nombre);

        sedeDTO.setSocios(
                sede.getSocios().stream()
                        .map(socio -> socioDTOConvert.socioToDTO(socio)).toList());

        /*
         * sedeDTO.setVoluntarios(
         * sede.getVoluntarios().stream()
         * .map(voluntario -> )
         * );
         */

        return sedeDTO;
    }

    public Sede dtoCrearToEntity(SedeDTOcrear sedeDTOcrear, Director director, Ciudad ciudad) {
        Sede sede = model.map(sedeDTOcrear, Sede.class);
        sede.setDirector(director);
        sede.setCiudad(ciudad);

        return sede;
    }

    public Sede updateEntityDtoUpdate(Sede sede, SedeDTOupdate sedeDTOupdate, Director director, Ciudad ciudad) {
        sede.setNombre(sedeDTOupdate.getNombre());
        sede.setCiudad(ciudad);
        sede.setDireccion(sedeDTOupdate.getDireccion());
        sede.setDirector(director);

        return sede;
    }

    public SedeDTOmostrar entityToDtoMostrar(Sede sede) {
        SedeDTOmostrar sedeDTOmostrar = model.map(sede, SedeDTOmostrar.class);

        sedeDTOmostrar.setSocios(
                sede.getSocios().stream()
                        .map(socio -> socio.getP_nombre().concat(" ")
                                .concat(socio.getS_nombre()).concat(" ")
                                .concat(socio.getP_apellido()).concat(" ")
                                .concat(socio.getS_apellido()))
                        .toList());

        sedeDTOmostrar.setVoluntarios(
                sede.getVoluntarios().stream()
                        .map(
                                voluntario -> {

                                    String nombre = "";
                                    nombre = nombre.concat(voluntario.getP_nombre())
                                            .concat(" ");

                                    if (voluntario.getS_nombre() != null) {
                                        nombre = nombre.concat(voluntario.getS_nombre()).concat(" ");
                                    }

                                    nombre = nombre.concat(voluntario.getP_apellido());
                                    if (voluntario.getS_apellido() != null) {
                                        nombre = nombre.concat(" ");
                                        nombre = nombre.concat(voluntario.getS_apellido());
                                    }

                                    return nombre;

                                })
                        .toList());

        sedeDTOmostrar.setCiudad(sede.getCiudad().getNombre());

        
        String director = "";

        if(sede.getDirector() != null) {
            director = director.concat(sede.getDirector().getP_nombre())
                    .concat(" ");

            if (sede.getDirector().getS_nombre() != null) {
                director = director.concat(sede.getDirector().getS_nombre()).concat(" ");
            }

            director = director.concat(sede.getDirector().getP_apellido());

            if (sede.getDirector().getS_apellido() != null) {
                director = director.concat(" ");
                director = director.concat(sede.getDirector().getS_apellido());
            }
        }
        else {
            director = "Sin asignar";
        }

        sedeDTOmostrar.setDirector(director);

        return sedeDTOmostrar;
    }

}
