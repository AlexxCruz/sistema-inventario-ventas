package com.brayan.sistema_inventario_ventas.modelo;

import jakarta.persistence.*;
import java.util.List;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_venta")
    Integer idVenta;

    @NotNull
    LocalDateTime fecha;

    @NotNull
    BigDecimal total;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    Usuario usuario;

    @OneToMany(mappedBy = "venta")
    List<DetalleVenta> detalles;



}
