package com.org.ProductosREST.controller;

import com.org.ProductosREST.model.Producto;
import com.org.ProductosREST.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private ProductoService servicio;

    @GetMapping("/listar")
    public List<Producto> listarProducto(){
        return servicio.listarProd();
    }

    /*
    @GetMapping("/buscar/{id}")
    public Producto buscarProducto(@PathVariable Integer id){
        return servicio.buscarProd(id);
    } */

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Producto> buscarProducto(@PathVariable Integer id){
        try {
            Producto producto = servicio.buscarProd(id);
            return new ResponseEntity<Producto>(producto, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/registrar")
    public void registrarProducto(@RequestBody Producto producto){
        servicio.registrarProd(producto);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizarProducto(@RequestBody Producto producto, @PathVariable Integer id){
        try {
            Producto productoActual = servicio.buscarProd(id);
            productoActual.setNombre(producto.getNombre());
            productoActual.setPrecio(producto.getPrecio());
            servicio.registrarProd(productoActual);
            return new ResponseEntity<Producto>(HttpStatus.OK);
        } catch (Exception exception){
            return new ResponseEntity<Producto>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarProducto(@PathVariable Integer id){
        servicio.eliminarProd(id);
    }




}
