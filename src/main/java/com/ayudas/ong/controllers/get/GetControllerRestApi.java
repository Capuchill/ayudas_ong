package com.ayudas.ong.controllers.get;

import org.springframework.web.bind.annotation.RestController;

import com.ayudas.ong.repositories.enums.TipoVoluntario;
import com.ayudas.ong.repositories.models.dtos.IngresoDTO;
import com.ayudas.ong.repositories.models.dtos.para_anidar.SedeDTOmostrar;
import com.ayudas.ong.services.sede.SedeServices;
import com.ayudas.ong.services.socios.SocioServices;
import com.ayudas.ong.services.voluntario.VoluntarioServices;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/{rol}/visualizar")
public class GetControllerRestApi {

    private final SocioServices socioServices;
    private final SedeServices sedeServices;
    private final VoluntarioServices voluntarioServices;

    // Listar socios por tipo de cuota

    @GetMapping("/socios/tipo-cuenta/{cuenta}")
    public ResponseEntity<Map<String, Object>> verSociosTipoCuenta(@PathVariable("cuenta") String cuenta) {

        Map<String, Object> response = new HashMap<>();
        List<IngresoDTO> socios = new ArrayList<>();

        try {
            socios = socioServices.buscarSocioByTipoCuenta(cuenta);

        } catch (DataAccessException e) {
            response.put("Mensaje", "No se pudo obtener el listado");
            response.put("Error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("Mensaje", " Lista de socios");
        response.put("Tipo de cuenta", cuenta);
        response.put("Lista de socios", socios);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Listar sedes

    @GetMapping("/sedes")
    public ResponseEntity<Map<String, Object>> verSedes() {

        Map<String, Object> response = new HashMap<>();
        List<SedeDTOmostrar> sedes = new ArrayList<>();

        try {
            sedes = sedeServices.findAll();

        } catch (DataAccessException e) {
            response.put("Mensaje", "No se pudo obtener el listado");
            response.put("Error", e.getMessage().concat(":").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("Mensaje", " Lista de sedes");
        response.put("Sedes", sedes);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/voluntario/listarXTipo/{tipo}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> ListarVoluntarios(@PathVariable String tipo) {
        Map<String, Object> response = new HashMap<>();
    
        try {
            TipoVoluntario myEnum = TipoVoluntario.valueOf(tipo.toUpperCase());
            System.out.println(myEnum);
            if (tipo.equalsIgnoreCase("sanitario")) {
                response.put("Lista voluntarios sanitarios", voluntarioServices.findAllSanitarios(myEnum));
            } else { 
                response.put("Lista voluntarios administrativos", voluntarioServices.findAllAdministrativos(myEnum));
            }
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            response.put("Mensaje", "No se encontró ese tipo de socio");
            return ResponseEntity.badRequest().body(response);
        }
    }
    
    
}
