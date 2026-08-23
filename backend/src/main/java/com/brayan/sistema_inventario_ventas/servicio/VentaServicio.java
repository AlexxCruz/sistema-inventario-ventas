package com.brayan.sistema_inventario_ventas.servicio;

import com.brayan.sistema_inventario_ventas.modelo.Venta;
import com.brayan.sistema_inventario_ventas.repositorio.VentaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServicio {

    private final VentaRepositorio ventaRepositorio;

    public VentaServicio(VentaRepositorio ventaRepositorio){
        this.ventaRepositorio = ventaRepositorio;

    }

    public List<Venta> listarVentas(){
        return ventaRepositorio.findAll();
    }

    public Venta buscarPorId(Integer id){
        return ventaRepositorio.findById(id).orElse(null);
    }

    public Venta guardar(Venta venta){
        return ventaRepositorio.save(venta);
    }

    public void eliminar(Integer id){
        ventaRepositorio.deleteById(id);
    }
}
