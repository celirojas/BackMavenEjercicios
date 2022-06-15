package com.example.clinicaOdontologica.controller;

import com.example.clinicaOdontologica.domain.Paciente;
import com.example.clinicaOdontologica.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    //Inyectamos la dependencia de PacienteService acá
    @Autowired
    private PacienteService pacienteService;


    @GetMapping("/todos")
    public List<Paciente> listarPacientes() {
        return pacienteService.listarPacientes();
    }


    @GetMapping("/{id}")
    public Paciente buscarPorId(@PathVariable int id){
       return pacienteService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable int id){
        if(pacienteService.eliminarPorId(id)){
            return ResponseEntity.ok("Paciente eliminado con exito");
        } else {
             return new ResponseEntity<>("No se encontro paciente", HttpStatus.NOT_FOUND);
        }

    }









    @GetMapping("/index")
    //RequestParam, el value = indicamos en la url el valor a evaluar, el required = false, indica que puede
    //ser o no pasado y el defaultValue que el valor por defecto que tome sea el indicado.
    public Model devolverUnPaciente(@RequestParam(value = "email", required = false, defaultValue = "no se encontro mail") String email, Model model) {
        Paciente paciente = pacienteService.devolverUnPaciente(email);

        if (paciente == null) return model;

        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());

        return model;


    }
}
