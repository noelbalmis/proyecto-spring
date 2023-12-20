package com.noel.proyecto.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.noel.proyecto.modelo.Carrito;
import com.noel.proyecto.modelo.Producto;
import com.noel.proyecto.servicios.CarritoServicio;

@Controller
public class OrdersController {

    @Autowired
    CarritoServicio carritoServicio;

    @GetMapping("/orders")
    public String mostrarPedidos(Model model) {
        model.addAttribute("pedidos", carritoServicio.obtenerCarritosPorEstado("pedido"));
        return "orders";
    }

    @PostMapping("/cancelorder")
    public String borraPedido(@RequestParam Long id) {
        Carrito carrito = carritoServicio.findById(id);
        carrito.setEstado("cancelado");
        carritoServicio.guardaCambios(carrito);
        return "redirect:/orders";
    }

}
