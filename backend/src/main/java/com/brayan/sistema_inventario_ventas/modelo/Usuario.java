package com.brayan.sistema_inventario_ventas.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    Integer idUsuario;

    @NotBlank
    String nombre;

    @NotBlank
    String username;

    @NotBlank
    String password;

    @NotBlank
    String rol;

    // "usuario" es el atributo de la clase Venta
    @OneToMany(mappedBy = "usuario")
    List<Venta> ventas;

    @OneToMany(mappedBy = "usuario")
    List<MovimientoInventario> movimientos;
}
