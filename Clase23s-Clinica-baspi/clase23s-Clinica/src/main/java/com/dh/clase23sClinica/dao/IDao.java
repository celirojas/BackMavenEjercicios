package com.dh.clase23sClinica.dao;

import java.util.List;

public interface IDao <T>{
    List<T> listarElementos();
    T buscarId (int id);
    T buscarEmail (String email);
    //Clase 25
    T guardar(T t);
    T actualizar(T t);
}
