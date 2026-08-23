package com.brayan.sistema_inventario_ventas.repositorio;

import com.brayan.sistema_inventario_ventas.modelo.MovimientoInventario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimientoInventarioRepositorio extends JpaRepository<MovimientoInventario, Integer> {

    @Query("SELECT m FROM MovimientoInventario m WHERE m.producto.idProducto = :idProducto")
    List<MovimientoInventario> listarProducto(
            @Param("idProducto") Integer idProducto);

    @Query("SELECT m FROM MovimientoInventario m WHERE m.tipo = :tipo")
    List<MovimientoInventario> listarPorTipo(
            @Param("tipo") String tipo);

    @Query("""
            SELECT m FROM MovimientoInventario m
            WHERE m.fecha BETWEEN :inicio AND :fin
            """)
    List<MovimientoInventario> listarPorFecha(
            @Param("inicio") LocalDateTime inicio,
            @Param("fin") LocalDateTime fin
    );
}
