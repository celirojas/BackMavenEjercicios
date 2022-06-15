package com.example.fechaNacimiento.model;

public class Fecha {
    //Atributos
    private int dia;
    private int mes;
    private int anio;

    //Constructor vacio
    public Fecha() {
    }

    //Constructor con atributos
    public Fecha(int dia, int mes, int anio) {
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    //Métodos accesores
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
