package com.brayan.sistema_inventario_ventas.servicio;

import com.brayan.sistema_inventario_ventas.modelo.Usuario;
import com.brayan.sistema_inventario_ventas.repositorio.UsuarioRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServicio {
    //conectamos UsuarioServicio con UsuarioRepositorio
    private final UsuarioRepositorio usuarioRepositorio;

    // Spring proporciona el UsuarioRepositorio al crear el servicio
    public UsuarioServicio(UsuarioRepositorio usuarioRepositorio){
        this.usuarioRepositorio = usuarioRepositorio;
    }

    //lista todos los usuarios
    public List<Usuario> listarUsuarios(){
        return usuarioRepositorio.findAll();
    }

    //buscara un usuario por ID
    public Usuario buscarPorId(Integer id){
        return usuarioRepositorio.findById(id).orElse(null);
    }

    // Guarda un usuario nuevo o actualiza uno existente
    public Usuario guardar(Usuario usuario){
        return usuarioRepositorio.save(usuario);
    }

    //eliminara un usuario por Id
    public void eliminar(Integer id){
        usuarioRepositorio.deleteById(id);
    }

}
