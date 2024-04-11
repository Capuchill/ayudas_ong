package com.ayudas.ong.controllers.create;

import org.springframework.web.bind.annotation.RestController;

import com.ayudas.ong.repositories.models.dtos.SedeDTO;
import com.ayudas.ong.repositories.models.dtos.SocioDTO;
import com.ayudas.ong.repositories.models.dtos.crear.SedeDTOcrear;
import com.ayudas.ong.repositories.models.dtos.crear.SocioDTOcrear;
import com.ayudas.ong.services.sede.SedeServices;
import com.ayudas.ong.services.socios.SocioServices;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor

@RestController
@RequestMapping("/api/v1/{rol}/crear")
public class CrearControllerRestApi {

    public final SocioServices socioServices;
    public final SedeServices sedeServices;

    @PostMapping("/socio")
    public ResponseEntity<Map<String, Object>> crearSocios(@Valid @RequestBody SocioDTOcrear socio,
            BindingResult result) {

        SocioDTO socioDTO = null;
        Map<String, Object> response = new HashMap<>();

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(
                            error -> error.getField() + " " + error.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("Errores", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            socioDTO = socioServices.crear(socio);

        } catch (DataAccessException e) {
            response.put("Mensaje", "No se pudo completar la creación del socio");
            response.put("Error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("Mensaje", "El socio fue creado con éxito.");
        response.put("Socio", socioDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping("/sede")
    public ResponseEntity<Map<String, Object>> crearSedes(@Valid @RequestBody SedeDTOcrear sede, BindingResult result) {

        Map<String, Object> response = new HashMap<>();
        SedeDTO sedeDTO = null;

        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(
                            error -> error.getField() + " " + error.getDefaultMessage())
                    .collect(Collectors.toList());

            response.put("Errores", errors);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            sedeDTO = sedeServices.crear(sede);

        } catch (DataAccessException e) {
            if(e.getMessage().contains("Duplicate entry")) {
                response.put("Mensaje", "No se pudo completar la creación de la sede");
                response.put("Error", "la ciudad de " + sede.getCiudad() + " ya tiene una sede asignada");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            else {
                response.put("Mensaje", "No se pudo completar la creación de la sede");
                response.put("Error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        response.put("Mensaje", "La sede fue creada con éxito.");
        response.put("Sede", sedeDTO);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
