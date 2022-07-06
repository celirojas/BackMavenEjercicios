package com.example.AlumnosEscuela.repository;

import com.example.AlumnosEscuela.modelo.Alumno;
import com.example.AlumnosEscuela.modelo.Escuela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EscuelaRepository extends JpaRepository<Escuela, Long> {


    @Query("SELECT e from Escuela where e.direccion = ?1")
    Optional<Escuela> busarEscuelas(String direccion);

}
