package com.example.EdadPersona25.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class EdadController {

    @GetMapping("/{dia}/{mes}/{anio}")
    public int calcularEdad(@PathVariable int anio){
        int anioActual = 2022;

        return anioActual - anio;
    }
}
