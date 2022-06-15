package com.example.peliculas27.controller;


import com.example.peliculas27.model.Pelicula;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PeliculaController {


    @GetMapping("/peliculas")
    public ResponseEntity<List<Pelicula>> listadoPeliculas(){
        Cine hoyts = new Cine();
        List<Pelicula> pelis = hoyts.getPeliculas();
        for (Pelicula peli: pelis) {
            peliculaADTO(peli);
        }
        return new ResponseEntity<>(pelis, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void eliminarPelicula(@PathVariable Integer id){
        Cine cinemark = new Cine();
        List<Pelicula> peliculas = cinemark.getPeliculas();
        for (Pelicula peli: peliculas) {
            if(peli.getID() == id){
                peliculas.remove(peli);
                System.out.println("Se elimino la pelicula.");
            }
            System.out.println("No se encontro la pelicula");
        }

    }

}
