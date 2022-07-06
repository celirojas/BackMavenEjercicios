package com.example.Partidos.controller;


import com.example.Partidos.model.Equipo;
import com.example.Partidos.service.EquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class Controller {

    @Autowired
    public EquipoService equipoService;

    @GetMapping
    public List<Equipo> listarEquipos(){
        return equipoService.buscarTodos();
    }
    @PostMapping
    public ResponseEntity<?> guardarEquipo(@RequestBody Equipo equipo){
        equipoService.guardar(equipo);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id){
        equipoService.eliminar(id);
        return "Se ha eliminado el equipo de id: " + id;
    }
}
