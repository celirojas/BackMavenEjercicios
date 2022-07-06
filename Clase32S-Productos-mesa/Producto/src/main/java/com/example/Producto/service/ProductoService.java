package com.example.Producto.service;

import com.example.Producto.domain.Producto;
import com.example.Producto.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {


    @Autowired
    IProductoRepository productoRepository;


    public ProductoService(IProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public Producto guardarProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public List<Producto> listarProductos(){
        return productoRepository.findAll();
    }

    public String eliminarProdcuto(Long id){
        productoRepository.deleteById(id);
        return "Producto eliminado: " + id;
    }

    public void restarCantidad(Producto producto) {
        productoRepository.save(producto);
    }


}
