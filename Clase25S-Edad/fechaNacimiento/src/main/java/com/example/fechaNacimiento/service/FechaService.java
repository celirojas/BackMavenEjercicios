package com.example.fechaNacimiento.service;

import com.example.fechaNacimiento.model.Fecha;

import java.time.LocalDate;
import java.time.Period;

public class FechaService {


    //Métodos
    public int calcularEdad(int dia, int mes, int anio){
        int edad = Period.between(LocalDate.of(anio,mes, dia), LocalDate.now()).getYears();
        return  edad;
    }
}
