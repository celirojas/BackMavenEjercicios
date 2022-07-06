package com.example.AlumnosEscuela.modelo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Escuela {

    @Id
    @SequenceGenerator(name = "escuela_sequence", sequenceName = "escuela_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "escuela_sequence")
    private Long id;
    private String nombre;
    private String direccion;



    //Una escuela tiene muchos alumnos
    @OneToMany(mappedBy = "escuela", fetch = FetchType.LAZY) //No va a cargar en la BD a los alumnos asociados a esta escuela hasta que no los necesite.
    private Set<Alumno> alumnos = new HashSet<>();


    public Escuela(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Escuela() {
    }
}
