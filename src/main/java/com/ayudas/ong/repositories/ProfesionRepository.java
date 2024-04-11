package com.ayudas.ong.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayudas.ong.repositories.entities.Profesion;
import java.util.List;


public interface ProfesionRepository extends JpaRepository<Profesion, Long>{
    
    List<Profesion> findByNombre(String nombre);
}
