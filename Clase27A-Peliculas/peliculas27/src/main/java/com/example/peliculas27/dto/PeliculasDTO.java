package com.example.peliculas27.dto;


import com.example.peliculas27.model.Pelicula;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PeliculasDTO {
    private String titulo;
    private String categoria;

    public PeliculasDTO(String titulo, String categoria) {
        this.titulo = titulo;
        this.categoria = categoria;
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

    public static void peliculaADto(Pelicula pelicula){
        ObjectMapper mapper = new ObjectMapper();
        PeliculasDTO peliDTO = mapper.convertValue(pelicula, PeliculasDTO.class);

    }
}
