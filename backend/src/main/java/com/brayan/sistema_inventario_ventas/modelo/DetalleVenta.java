package com.brayan.sistema_inventario_ventas.modelo;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="detalle_venta")
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_detalle_venta")
    Integer idDetalleVenta;

    @ManyToOne
    @JoinColumn(name="id_venta")
    Venta venta;

    @ManyToOne
    @JoinColumn(name="id_producto")
    Producto producto;

    @NotNull
    Integer cantidad;

    @NotNull
    BigDecimal precio;

    @NotNull
    @Column(name="subtotal")
    BigDecimal subTotal;


}
