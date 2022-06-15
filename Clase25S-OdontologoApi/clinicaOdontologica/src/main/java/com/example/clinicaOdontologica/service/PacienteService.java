package com.example.clinicaOdontologica.service;

import com.example.clinicaOdontologica.domain.Domicilio;
import com.example.clinicaOdontologica.domain.Paciente;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class PacienteService {

    //Métodos
    public List<Paciente> listarPacientes() {
        //Harcodeamos la lista de pacientes
        return Arrays.asList(new Paciente(1, "Anderson", "Laura", "laura@gmail.com",
                "39.185.319", LocalDate.of(2022, 06, 9), new Domicilio(1,
                "Carlos Ortiz", 835, "capital federal", "CABA")),new Paciente(2,
                "Rojas", "Celina", "celina@gmail.com", "40.200.319",
                LocalDate.of(2022, 06, 10), new Domicilio(2, "Carlos Ortiz",
                835, "capital federal", "CABA")), new Paciente(3, "Gomez", "Pedro", "pedro@gmail.com",
                "39.185.319", LocalDate.of(2022, 06, 9), new Domicilio(1,
                "Maipu", 144, "Saavedra", "CABA")));
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
    public Paciente buscarPorId(int id){
        Paciente pacienteEncontrado = null;
        for (Paciente paciente : listarPacientes()) {
            if (paciente.getId() == id) {
                pacienteEncontrado = paciente;
            }


        }
        return pacienteEncontrado;
    }

    public Boolean eliminarPorId(int id){
        Paciente paciente = buscarPorId(id);
        if (paciente != null) {
            listarPacientes().remove(paciente);
            return true;
        }
        return false;
    }


}
