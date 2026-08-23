package com.brayan.sistema_inventario_ventas.controlador;

import com.brayan.sistema_inventario_ventas.servicio.UsuarioServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sistema/usuarios") //ruta base de este controlador
@CrossOrigin(value = "http://localhost:4200")//aceptar peticiones desde otro puerto
public class UsuarioControlador {
    //atributo para el manejo de loggin
    private static final Logger logger = //objeto para mensajes en consola
            LoggerFactory.getLogger(UsuarioControlador.class);

    private final UsuarioServicio usuarioServicio;

    public UsuarioControlador(UsuarioServicio usuarioServicio) {
        this.usuarioServicio = usuarioServicio;
    }
}
