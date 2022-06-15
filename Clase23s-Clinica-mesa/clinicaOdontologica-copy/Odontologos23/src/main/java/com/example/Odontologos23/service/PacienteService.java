package com.example.Odontologos23.service;

import com.example.Odontologos23.domain.Domicilio;
import com.example.Odontologos23.domain.Paciente;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class PacienteService {

    public List<Paciente> listarPacientes() {
        return Arrays.asList(new Paciente(1, "Anderson", "Laura", "laura@gmail.com", "39.185.319", LocalDate.of(2022, 06, 9), new Domicilio(1, "Carlos Ortiz", 835, "capital federal", "CABA")),new Paciente(2, "Rojas", "Celina", "celina@gmail.com", "40.200.319", LocalDate.of(2022, 06, 10), new Domicilio(2, "Carlos Ortiz", 835, "capital federal", "CABA")));
    }

    public Paciente devolverUnPaciente(String email) {
        Paciente pacienteEncontrado = null;
        for (Paciente paciente : listarPacientes()) {
            if (paciente.getEmail().equals(email)) {
                pacienteEncontrado = paciente;
            }


        }
        return pacienteEncontrado;

    }


}

