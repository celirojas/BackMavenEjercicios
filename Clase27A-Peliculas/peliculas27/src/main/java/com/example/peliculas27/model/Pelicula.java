package com.example.peliculas27.model;

public class Pelicula {
    private String titulo;
    private String categoria;
    private Integer premios;
    private Integer ID;

    public Pelicula() {
    }

    public Pelicula(String titulo, String categoria, Integer premios, Integer ID) {
        this.titulo = titulo;
        this.categoria = categoria;
        this.premios = premios;
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getPremios() {
        return premios;
    }

    public void setPremios(Integer premios) {
        this.premios = premios;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
}
