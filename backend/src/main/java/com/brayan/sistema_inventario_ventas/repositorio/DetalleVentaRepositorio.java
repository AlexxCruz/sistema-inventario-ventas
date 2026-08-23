package com.brayan.sistema_inventario_ventas.repositorio;

import com.brayan.sistema_inventario_ventas.modelo.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DetalleVentaRepositorio extends JpaRepository<DetalleVenta, Integer> {
                                                        //parametro nombrado
    @Query("SELECT d FROM DetalleVenta d WHERE d.venta.idVenta = :idVenta")
    List<DetalleVenta> findByVentaIdVenta(
            @Param("idVenta") Integer idVenta);
}
