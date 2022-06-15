package com.dh.clase23sClinica.services;

import com.dh.clase23sClinica.dao.IDao;
import com.dh.clase23sClinica.dominio.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService implements PacienteServiceInterface{
    private IDao<Paciente> pacienteIDao;

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    //Tiene que trabajar con el DAO
    @Override
    public List<Paciente> listarPacientes() {
        return pacienteIDao.listarElementos();
    }

    @Override
    public Paciente buscarXemail(String email) {
        return pacienteIDao.buscarEmail(email);
    }

    //Clase 25
    @Override
    public Paciente guardar(Paciente paciente) {
        return pacienteIDao.guardar(paciente);
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        return pacienteIDao.actualizar(paciente);
    }
}
