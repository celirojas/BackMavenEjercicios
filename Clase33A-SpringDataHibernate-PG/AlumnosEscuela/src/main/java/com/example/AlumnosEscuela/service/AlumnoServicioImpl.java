package com.example.AlumnosEscuela.service;

import com.example.AlumnosEscuela.modelo.Alumno;
import com.example.AlumnosEscuela.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AlumnoServicioImpl {

    private AlumnoRepository alumnoRepository;

    @Autowired

    public AlumnoServicioImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }


    public List<Alumno> buscarTodos(){
        return alumnoRepository.findAll();
    }

    public Alumno buscarPorNombre(String nombre){
        return alumnoRepository.buscarAlumno(nombre).get();
    }
}
