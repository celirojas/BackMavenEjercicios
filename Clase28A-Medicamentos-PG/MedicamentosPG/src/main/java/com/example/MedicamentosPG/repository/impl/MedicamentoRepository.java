package com.example.MedicamentosPG.repository.impl;

import com.example.MedicamentosPG.dto.MedicamentoDTO;
import com.example.MedicamentosPG.repository.IRepositoryRest;
import com.example.MedicamentosPG.util.Jsons;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;



public class MedicamentoRepository implements IRepositoryRest<MedicamentoDTO> {

    @Override
    public MedicamentoDTO guardar(MedicamentoDTO medicamentoDTO) {
        //Para guardar el JSON. Vamos a guardar el response. El tipo de dato es el del BODY y después de String lo pasamos a Medicamento.
        HttpResponse<String> response = null;
        MedicamentoDTO medicamento = null;

        try{
            //Lo que nos devolvió la API
            response = Unirest.post("http://localhost:8080/medicamentos/registrar")
                    .header("Content-Type", "application/json")
                    .body(Jsons.asJsonString(medicamentoDTO)).asString(); //Convertir a JSON el medicamentoDTO que nos llega.

            //Queremos un medicamentoDTO y lo sacamos del body de la respuesta
            medicamento = Jsons.objectFromString(MedicamentoDTO.class,response.getBody());



        }catch(Exception e){
            e.printStackTrace();
        }
        return medicamento;
    }

    @Override
    public MedicamentoDTO buscar(Integer id) {
        //Para guardar el JSON. Vamos a guardar el response. El tipo de dato es el del BODY y después de String lo pasamos a Medicamento.
        HttpResponse<String> response = null;
        MedicamentoDTO medicamento = null;

        try{
            //Lo que nos devolvió la API
            response = Unirest.get("http://localhost:8080/medicamentos/"+id)
                    .asString(); //Convertir a JSON el medicamentoDTO que nos llega.

            //Queremos un medicamentoDTO y lo sacamos del body de la respuesta
            medicamento = Jsons.objectFromString(MedicamentoDTO.class,response.getBody());



        }catch(Exception e){
            e.printStackTrace();
        }
        return medicamento;
    }

    @Override
    public MedicamentoDTO update(MedicamentoDTO medicamentoDTO) {
        //Para guardar el JSON. Vamos a guardar el response. El tipo de dato es el del BODY y después de String lo pasamos a Medicamento.
        HttpResponse<String> response = null;
        MedicamentoDTO medicamento = null;

        try{
            //Lo que nos devolvió la API
            response = Unirest.put("http://localhost:8080/medicamentos/actualizar")
                    .header("Content-Type", "application/json")
                    .body(Jsons.asJsonString(medicamentoDTO)).asString(); //Convertir a JSON el medicamentoDTO que nos llega.

            //Queremos un medicamentoDTO y lo sacamos del body de la respuesta
            medicamento = Jsons.objectFromString(MedicamentoDTO.class,response.getBody());



        }catch(Exception e){
            e.printStackTrace();
        }
        return medicamento;
    }

    @Override
    public String eliminar(Integer id) {

        //Para guardar el JSON. Vamos a guardar el response. El tipo de dato es el del BODY y después de String lo pasamos a Medicamento.
        HttpResponse<String> response = null;

        try{
            //Lo que nos devolvió la API
            response = Unirest.delete("http://localhost:8080/medicamentos/"+id).asString(); //Convertir a JSON el medicamentoDTO que nos llega.


        }catch(Exception e){
            e.printStackTrace();
        }
        return response!= null ? String.valueOf(response.getStatus()) : null;
    }
}
