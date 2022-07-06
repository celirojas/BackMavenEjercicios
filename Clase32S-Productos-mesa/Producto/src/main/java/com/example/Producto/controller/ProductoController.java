package com.example.Producto.controller;

import com.example.Producto.domain.Producto;
import com.example.Producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;




    @GetMapping("/listar")
    public ResponseEntity listarProductos(){
        return new ResponseEntity(productoService.listarProductos(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarProducto(@PathVariable Long id){
        productoService.eliminarProdcuto(id);
        return new ResponseEntity("Producto eliminado correctamente." , HttpStatus.OK);
    }

    @PostMapping("/guardar")
    public ResponseEntity guardarProducto(@RequestBody Producto producto){
        productoService.guardarProducto(producto);
        return new ResponseEntity("Producto creado correctamente." , HttpStatus.OK) ;
    }
    @PutMapping("/restarCantidad/{id}")
    public ResponseEntity restarProducto(@RequestBody Producto producto) {
        producto.setCantidad(producto.getCantidad() - 1);
        productoService.restarCantidad(producto);
        return new ResponseEntity("Cantidad restada correctamente. La cantidad restante es: " + producto.getCantidad(), HttpStatus.OK);
    }


}
