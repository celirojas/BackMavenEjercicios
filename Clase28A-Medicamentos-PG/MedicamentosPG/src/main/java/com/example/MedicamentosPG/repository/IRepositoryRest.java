package com.example.MedicamentosPG.repository;

public interface IRepositoryRest<T> {
    T guardar(T t);
    T buscar(Integer id);
    T update(T t);
    String eliminar(Integer id);
}
