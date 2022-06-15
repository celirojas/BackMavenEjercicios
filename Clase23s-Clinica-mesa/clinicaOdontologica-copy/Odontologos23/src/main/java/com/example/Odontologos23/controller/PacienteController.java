package com.example.Odontologos23.controller;

import com.example.Odontologos23.domain.Paciente;
import com.example.Odontologos23.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;


    @GetMapping("/todos")
    public List<Paciente> listarPacientes() {
        return pacienteService.listarPacientes();
    }

//    @GetMapping("/index")
//    public Model devolverUnPaciente(@RequestParam(value = "email", required = false, defaultValue = "celina@gmail.com") String email, Model model) {
//        Paciente paciente = pacienteService.devolverUnPaciente(email);
//
//        if (paciente == null) return model;
//
//        model.addAttribute("nombre", paciente.getNombre());
//        model.addAttribute("apellido", paciente.getApellido());
//
//        return model;
//
//
//    }

    //Traer pacientes por email via query params simple
    @GetMapping("/index")
    public Model devolverUnPaciente(@RequestParam String email, Model model) {
        Paciente paciente = pacienteService.devolverUnPaciente(email);

        if (paciente == null) return model;

        model.addAttribute("nombre", paciente.getNombre());
        model.addAttribute("apellido", paciente.getApellido());

        return model;

    }
}
