package com.dh.clase23sClinica.services;

import com.dh.clase23sClinica.dominio.Paciente;

import java.util.List;

public interface PacienteServiceInterface {
    List<Paciente> listarPacientes();
    Paciente buscarXemail(String email);

    //Clase25
    Paciente guardar(Paciente paciente);
    Paciente actualizar(Paciente paciente);
}
