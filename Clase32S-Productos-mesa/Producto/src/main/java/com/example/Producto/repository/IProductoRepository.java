package com.example.Producto.repository;

import com.example.Producto.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository <Producto, Long>{

}
