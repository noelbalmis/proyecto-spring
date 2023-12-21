package com.noel.proyecto.controladores;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.noel.proyecto.modelo.Carrito;
import com.noel.proyecto.modelo.Producto;
import com.noel.proyecto.modelo.Usuario;
import com.noel.proyecto.servicios.CarritoServicio;
import com.noel.proyecto.servicios.UsuarioServicio;

@Controller
public class OrdersController {

    @Autowired
    CarritoServicio carritoServicio;

    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/orders")
    public String mostrarPedidos(Model model) {
        model.addAttribute("pedidos", carritoServicio.obtenerCarritosPorEstado("pedido"));
        return "orders";
    }

    @PostMapping("/makeorder")
    public String creaPedido(Principal principal) {
        Usuario usuario = usuarioServicio.buscarPorEmail(principal.getName());
        Carrito carritoActivo = usuario.getCarritoActivo();
        carritoActivo.setEstado("pedido");
        carritoActivo.setFecha(LocalDateTime.now());

        usuarioServicio.creaCarritoActivo(usuario);

        usuarioServicio.guardaCambios(usuario);
        return "redirect:/orders";
    }

    @PostMapping("/cancelorder")
    public String borraPedido(@RequestParam Long id) {
        Carrito carrito = carritoServicio.findById(id);
        carrito.setEstado("cancelado");
        carritoServicio.guardaCambios(carrito);
        return "redirect:/orders";
    }

}
