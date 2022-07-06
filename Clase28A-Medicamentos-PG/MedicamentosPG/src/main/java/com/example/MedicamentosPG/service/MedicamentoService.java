package com.example.MedicamentosPG.service;

import com.example.MedicamentosPG.dto.MedicamentoDTO;
import com.example.MedicamentosPG.repository.IRepositoryRest;

public class MedicamentoService {

    private IRepositoryRest<MedicamentoDTO> medicamentoRepository;

    public MedicamentoService(IRepositoryRest<MedicamentoDTO> medicamentoRepository) {
        this.medicamentoRepository = medicamentoRepository;
    }

    public MedicamentoDTO guardarMedicamento(MedicamentoDTO medicamentoDTO){
        return medicamentoRepository.guardar(medicamentoDTO);
    }


    public MedicamentoDTO actualizarMedicamento(MedicamentoDTO medicamentoDTO){
        return medicamentoRepository.update(medicamentoDTO);
    }


    public String eliminar(Integer id){
        return medicamentoRepository.eliminar(id);
    }

    public MedicamentoDTO buscar(Integer id){
        return medicamentoRepository.buscar(id);
    }

}
