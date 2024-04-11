package com.ayudas.ong.controllers.update;

import org.springframework.web.bind.annotation.RestController;

import com.ayudas.ong.repositories.models.dtos.SocioDTO;
import com.ayudas.ong.repositories.models.dtos.VoluntarioAdminDTO;
import com.ayudas.ong.repositories.models.dtos.actualizar.SedeDTOupdate;
import com.ayudas.ong.repositories.models.dtos.actualizar.SocioDTOupdate;
import com.ayudas.ong.repositories.models.dtos.actualizar.VoluntarioAdminDTOupdate;
import com.ayudas.ong.repositories.models.dtos.para_anidar.SedeDTOmostrar;
import com.ayudas.ong.services.sede.SedeServices;
import com.ayudas.ong.services.socios.SocioServices;
import com.ayudas.ong.services.voluntario.VoluntarioServices;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/{rol}/update")
public class UpdateControllerRestApi {

    private final SocioServices socioServices;
    private final SedeServices sedeServices;
    private final VoluntarioServices voluntarioServices;

    @PutMapping("/socio/{cedula}")
    public ResponseEntity<Map<String, Object>> actualizarSocio(@Valid @PathVariable long cedula, @RequestBody SocioDTOupdate socio, BindingResult result) {
        
        SocioDTO socioDTO = null;
        Map<String,Object> response = new HashMap<>();

        if(result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                .stream()
                .map(
                    error -> error.getField() + " " + error.getDefaultMessage()
                )
                .collect(Collectors.toList());
            
            response.put("Errores", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            socioDTO = socioServices.update(cedula, socio);

        } catch (DataAccessException e) {
            response.put("Mensaje", "No se pudo completar la actualización del socio");
            response.put("Error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("Mensaje", "El socio fue actualizado con éxito.");
        response.put("Socio", socioDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @PutMapping("/sede/{nombre}")
    public ResponseEntity<Map<String, Object>> actualizarSede(@Valid @PathVariable String nombre, @RequestBody SedeDTOupdate sedeDTOupdate, BindingResult result) {
        

        nombre = nombre.replace("-", " ");
        SedeDTOmostrar sedeDTO = null;
        Map<String,Object> response = new HashMap<>();

        if(result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                .stream()
                .map(
                    error -> error.getField() + " " + error.getDefaultMessage()
                )
                .collect(Collectors.toList());
            
            response.put("Errores", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            sedeDTO = sedeServices.updateInfoBasic(nombre, sedeDTOupdate);

        } catch (DataAccessException e) {
            if(e.getMessage().contains("Duplicate entry")) {
                response.put("Mensaje", "No se pudo completar la creación de la sede");
                response.put("Error", "la ciudad de " + sedeDTOupdate.getCiudad() + " ya tiene una sede asignada");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            else {
                response.put("Mensaje", "No se pudo completar la actualización de la sede");
                response.put("Error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        response.put("Mensaje", "La sede fue actualizada con éxito.");
        response.put("Sede", sedeDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/voluntario/administrativo/{cedula}")
    public ResponseEntity<Map<String, Object>> actualizarVoluntario(@Valid @PathVariable long cedula, @RequestBody VoluntarioAdminDTOupdate voluntarioAdminDTOupdate, BindingResult result) {
        
        VoluntarioAdminDTO voluntarioAdminDTO = null;
        Map<String,Object> response = new HashMap<>();

        if(result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                .stream()
                .map(
                    error -> error.getField() + " " + error.getDefaultMessage()
                )
                .collect(Collectors.toList());
            
            response.put("Errores", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            voluntarioAdminDTO = voluntarioServices.updateAdmin(voluntarioAdminDTOupdate, cedula);

        } catch (DataAccessException e) {
            /* if(e.getMessage().contains("Duplicate entry")) {
                response.put("Mensaje", "No se pudo completar la creación de la sede");
                response.put("Error", "la ciudad de " + voluntarioAdminDTOupdate.() + " ya tiene una sede asignada");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            else {
                response.put("Mensaje", "No se pudo completar la actualización de la sede");
                response.put("Error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            } */

            response.put("Mensaje", "No se pudo completar la actualización del voluntario");
            response.put("Error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("Mensaje", "El voluntario fue actualizado con éxito.");
        response.put("Sede", voluntarioAdminDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
