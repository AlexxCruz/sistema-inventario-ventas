package com.brayan.sistema_inventario_ventas.repositorio;

import com.brayan.sistema_inventario_ventas.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

    //creamos una consulta (JPQL)
    @Query("SELECT p FROM Producto p WHERE p.stock <= p.stockMinimo")
    List<Producto> buscarProductosConStockBajo();
}
