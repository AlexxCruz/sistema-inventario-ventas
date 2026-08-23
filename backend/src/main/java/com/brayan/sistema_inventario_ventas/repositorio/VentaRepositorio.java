package com.brayan.sistema_inventario_ventas.repositorio;

import com.brayan.sistema_inventario_ventas.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepositorio extends JpaRepository<Venta, Integer> {
}
