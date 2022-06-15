package com.dh.clase23sClinica.controller;


import com.dh.clase23sClinica.dominio.Paciente;
import com.dh.clase23sClinica.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    private final PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/index")
    public String traerPaciente(Model model, @RequestParam("email") String email){
        //Buscar al paciente por email
        Paciente paciente = pacienteService.buscarXemail(email);
        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());

        return "index";
    }

    @PostMapping
    public Paciente registrarPaciente(@RequestBody Paciente paciente){ //Lo convierte a objeto paciente según sus atributos
        return pacienteService.guardar(paciente);
    }

    @PutMapping
    public Paciente actualizarPaciente(@RequestBody Paciente paciente){
        return pacienteService.actualizar(paciente);
    }
}
