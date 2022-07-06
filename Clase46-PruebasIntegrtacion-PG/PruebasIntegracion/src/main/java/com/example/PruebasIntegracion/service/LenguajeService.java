package com.example.PruebasIntegracion.service;

import com.example.PruebasIntegracion.modelo.Lenguaje;

import java.util.ArrayList;
import java.util.List;

public class LenguajeService {

    List<Lenguaje> lenguajes = new ArrayList<>();

    public LenguajeService() {
        lenguajes.add(new Lenguaje("Java", true));
        lenguajes.add(new Lenguaje("Pascal", false));
    }

    public Lenguaje buscarPorTipo(String tipo){
        for (Lenguaje lenguaje: lenguajes) {
            if(lenguaje.getTipo().equals(tipo)){
                return lenguaje;
            }

        }
        return null;
    }

    public List<Lenguaje> buscarTodos(){
        return lenguajes;
    }
}
