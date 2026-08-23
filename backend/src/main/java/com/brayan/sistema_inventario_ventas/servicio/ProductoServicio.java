package com.brayan.sistema_inventario_ventas.servicio;

import com.brayan.sistema_inventario_ventas.modelo.Producto;
import com.brayan.sistema_inventario_ventas.repositorio.ProductoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServicio {

    private final ProductoRepositorio productoRepositorio;

    public ProductoServicio(ProductoRepositorio productoRepositorio){
        this.productoRepositorio = productoRepositorio;
    }

    public List<Producto> listarProductos(){
        return productoRepositorio.findAll();
    }

    public List<Producto> buscarProductosConStockBajo(){
        return productoRepositorio.buscarProductosConStockBajo();
    }

    public Producto buscarPorId(Integer id){
        return productoRepositorio.findById(id).orElse(null);
    }

    public Producto guardar(Producto producto){
        return productoRepositorio.save(producto);
    }

    //no regresara ningun valor
    public void eliminar(Integer id){
        productoRepositorio.deleteById(id);
    }



}

