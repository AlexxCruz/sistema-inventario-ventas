package com.brayan.sistema_inventario_ventas.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_productos")
    Integer idProducto;

    @NotBlank
    String nombre;

    @NotBlank
    String descripcion;

    @NotNull
    BigDecimal precio;

    @NotNull
    Integer stock;

    @NotNull
    @Column(name="stock_minimo")
    Integer stockMinimo;

    @OneToMany(mappedBy="producto")
    List<DetalleVenta>detalles;

    @OneToMany(mappedBy = "producto")
    List<MovimientoInventario> movimientos;
}
