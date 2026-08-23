package com.brayan.sistema_inventario_ventas.repositorio;

import com.brayan.sistema_inventario_ventas.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>  {
}
