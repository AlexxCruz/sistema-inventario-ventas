package com.brayan.sistema_inventario_ventas.servicio;

import com.brayan.sistema_inventario_ventas.modelo.DetalleVenta;
import com.brayan.sistema_inventario_ventas.repositorio.DetalleVentaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServicio {

    private final DetalleVentaRepositorio detalleVentaRepositorio;

    public DetalleVentaServicio(DetalleVentaRepositorio detalleVentaRepositorio){
        this.detalleVentaRepositorio=detalleVentaRepositorio;
    }

    public List<DetalleVenta> listarDeatlles(){
        return detalleVentaRepositorio.findAll();
    }

    public DetalleVenta buscarPorId(Integer id){
        return detalleVentaRepositorio.findById(id).orElse(null);
    }

    public DetalleVenta guardar(DetalleVenta detalleVenta){
        return detalleVentaRepositorio.save(detalleVenta);
    }

    public void eliminar(Integer id){
        detalleVentaRepositorio.deleteById(id);
    }

    public List<DetalleVenta> listarPorVenta(Integer idVenta){
        return detalleVentaRepositorio.findByVentaIdVenta(idVenta);
    }


}
