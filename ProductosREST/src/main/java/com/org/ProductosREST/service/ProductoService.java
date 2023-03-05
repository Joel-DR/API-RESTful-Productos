package com.org.ProductosREST.service;

import com.org.ProductosREST.model.Producto;
import com.org.ProductosREST.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    // LISTAR PRODUCTOS
    public List<Producto> listarProd(){
        return repository.findAll();
    }

    // REGISTRAR PRODUCTO
    public void registrarProd(Producto producto){
        repository.save(producto);
    }

    // BUSCAR PRODUCTO POR ID
    public Producto buscarProd(Integer id){
        return repository.findById(id).get();
    }

    // ELIMINAR PRODUCTO
    public void eliminarProd(Integer id){
        repository.deleteById(id);
    }

}
