package com.example.AlumnosEscuela.repository;

import com.example.AlumnosEscuela.modelo.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {


    @Query("SELECT a from Alumno where a.nombre = ?1")
    Optional<Alumno> buscarAlumno(String nombre);

}
