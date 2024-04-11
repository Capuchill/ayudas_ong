package com.ayudas.ong.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayudas.ong.repositories.entities.Voluntario;
import java.util.List;
import com.ayudas.ong.repositories.enums.TipoVoluntario;


public interface VoluntarioRepository extends JpaRepository<Voluntario, Long>{

    List<Voluntario> findByTipo(TipoVoluntario tipo);

    Voluntario findByCedula(long cedula);

    Voluntario findByEmail(String email);

    
}