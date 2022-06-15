package com.example.fechaNacimiento.controller;

import com.example.fechaNacimiento.model.Fecha;
import com.example.fechaNacimiento.service.FechaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fecha")//Funciona como pre-fijo de la url de  los métodos
public class FechaController {
    //Instanciamos el servicio
    private FechaService fechaService = new FechaService();
    //Métodos
    @GetMapping(path = "{dia}/{mes}/{anio}") public int calcularEdad( @PathVariable int dia,
      @PathVariable int mes, @PathVariable int anio) {
        return fechaService.calcularEdad(dia, mes, anio);
    }
}
