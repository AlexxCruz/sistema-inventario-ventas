package com.brayan.sistema_inventario_ventas.servicio;

import com.brayan.sistema_inventario_ventas.modelo.MovimientoInventario;
import com.brayan.sistema_inventario_ventas.repositorio.MovimientoInventarioRepositorio;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimientoInventarioServicio {

    private final MovimientoInventarioRepositorio movimientoInventarioRepositorio;

    public MovimientoInventarioServicio(MovimientoInventarioRepositorio movimientoInventarioRepositorio) {
        this.movimientoInventarioRepositorio = movimientoInventarioRepositorio;
    }

    public List<MovimientoInventario> listarMovimientos() {
        return movimientoInventarioRepositorio.findAll();
    }

    public MovimientoInventario buscarPorId(Integer id) {
        return movimientoInventarioRepositorio.findById(id).orElse(null);
    }

    public MovimientoInventario guardar(MovimientoInventario movimientoInventario) {
        return movimientoInventarioRepositorio.save(movimientoInventario);
    }

    public void eliminar(Integer id) {
        movimientoInventarioRepositorio.deleteById(id);
    }

    public List<MovimientoInventario> listarPorProducto(Integer idProducto) {
        return movimientoInventarioRepositorio.listarProducto(idProducto);
    }

    public List<MovimientoInventario> listarPorTipo(String tipo) {
        return movimientoInventarioRepositorio.listarPorTipo(tipo);
    }

    public List<MovimientoInventario> listarPorFecha(
            LocalDateTime inicio,
            LocalDateTime fin){
        return movimientoInventarioRepositorio.listarPorFecha(inicio, fin);
    }

}
