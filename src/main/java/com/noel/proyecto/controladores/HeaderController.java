package com.noel.proyecto.controladores;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.noel.proyecto.servicios.CarritoServicio;
import com.noel.proyecto.servicios.UsuarioServicio;

@ControllerAdvice
public class HeaderController {

    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    CarritoServicio carritoServicio;

    @ModelAttribute
    public void addCommonAttributes(Model model, Principal principal) {
        if (principal != null) {
            model.addAttribute("esAdministrador", usuarioServicio.buscarPorEmail(principal.getName()).getRol().equals("admin"));
            model.addAttribute("nombreUsuario", usuarioServicio.buscarPorEmail(principal.getName()).getNombre());
            model.addAttribute("numeroProductosEnCarrito", carritoServicio
                    .getNumeroProductos(usuarioServicio.buscarPorEmail(principal.getName()).getCarritoActivo()));
            model.addAttribute("numeroPedidos", carritoServicio.obtenerCarritosPorEstado("pedido").size());
        }
    }

}
