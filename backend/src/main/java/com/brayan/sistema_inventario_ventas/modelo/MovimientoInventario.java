package com.brayan.sistema_inventario_ventas.modelo;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="movimientos_inventario")
public class MovimientoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_movimiento")
    Integer idMovimiento;

    @ManyToOne
    @JoinColumn(name="id_producto")
    Producto producto;

    @NotBlank
    String tipo;

    @NotNull
    Integer cantidad;

    @NotNull
    LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    Usuario usuario;



}
