package com.example.PruebasIntegracion.controller;

import com.example.PruebasIntegracion.modelo.Lenguaje;
import com.example.PruebasIntegracion.service.LenguajeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LenguajeController {

    private LenguajeService lenguajeService = new LenguajeService();

    @GetMapping("/lenguajes/{tipo}")
    public ResponseEntity<?> obtenerLenguajePorTipo(@PathVariable("tipo") String tipo){
        Lenguaje lenguaje = lenguajeService.buscarPorTipo(tipo);
        if(lenguaje == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(lenguaje, HttpStatus.OK);
    }

    @GetMapping("/lenguajes")
    public ResponseEntity<?>obtenerTodosLosLenguajes(){
        return new ResponseEntity(lenguajeService.buscarTodos(), HttpStatus.OK);
    }
}
