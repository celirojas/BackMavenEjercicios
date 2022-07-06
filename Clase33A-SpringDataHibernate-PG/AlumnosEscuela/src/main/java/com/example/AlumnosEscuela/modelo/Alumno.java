package com.example.AlumnosEscuela.modelo;


import javax.persistence.*;

@Entity
@Table
public class Alumno {

    @Id
    @SequenceGenerator(name= "alumno_sequence", sequenceName = "alumno_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alumno_sequence")
    private Long id;
    private String nombre;
    private int edad;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //El lazy no tiene mucho sentido aca porque solo evitariamos que me muestre una sola escuela
    @JoinColumn(name = "escuela_id")
    private Escuela escuela;


    public Alumno() {
    }

    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
