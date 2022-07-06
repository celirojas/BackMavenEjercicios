package com.example.PruebasIntegracion.modelo;

public class Lenguaje {

    private String tipo;
    private Boolean esOrientadoAObjetos;

    public Lenguaje(String tipo, Boolean esOrientadoAObjetos) {
        this.tipo = tipo;
        this.esOrientadoAObjetos = esOrientadoAObjetos;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Boolean getEsOrientadoAObjetos() {
        return esOrientadoAObjetos;
    }

    public void setEsOrientadoAObjetos(Boolean esOrientadoAObjetos) {
        this.esOrientadoAObjetos = esOrientadoAObjetos;
    }
}
