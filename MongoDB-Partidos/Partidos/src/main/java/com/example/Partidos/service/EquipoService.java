package com.example.Partidos.service;

import com.example.Partidos.model.Equipo;
import com.example.Partidos.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService {

    @Autowired
    EquipoRepository equipoRepository;


    public EquipoService(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public void guardar(Equipo equipo){
        equipoRepository.save(equipo);
    }
    public void eliminar(Long id){
        equipoRepository.deleteById(id);
    }
    public List<Equipo> buscarTodos(){
        return equipoRepository.findAll();
    }

}
