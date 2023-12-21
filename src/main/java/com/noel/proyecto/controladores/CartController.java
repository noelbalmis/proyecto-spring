package com.noel.proyecto.controladores;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.noel.proyecto.modelo.Carrito;
import com.noel.proyecto.modelo.Producto;
import com.noel.proyecto.modelo.Usuario;
import com.noel.proyecto.servicios.CarritoServicio;
import com.noel.proyecto.servicios.ProductoServicio;
import com.noel.proyecto.servicios.UsuarioServicio;

@Controller
public class CartController {

    @Autowired
    ProductoServicio productoServicio;

    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    CarritoServicio carritoServicio;

    @GetMapping("/cart")
    public String carrito(Model model, Principal principal) {
        model.addAttribute("productosCarrito",
                usuarioServicio.buscarPorEmail(principal.getName()).getCarritoActivo().getProductos());
        model.addAttribute("carrito",
                usuarioServicio.buscarPorEmail(principal.getName()).getCarritoActivo());
        return "cart";
    }

    @PostMapping("/addtocart/{idProducto}")
    public String añadeAlCarrito(@PathVariable("idProducto") Long idProducto, Principal principal) {
        Producto productoAIntroducir = productoServicio.getProductoPorId(idProducto);
        Usuario usuario = usuarioServicio.buscarPorEmail(principal.getName());
        Carrito nuevoCarrito = usuario.getCarritoActivo();
        nuevoCarrito.addProducto(productoAIntroducir);
        usuarioServicio.guardaCambios(usuario);
        return "redirect:/cart";
    }

    @PostMapping("/removefromcart/{idProducto}")
    public String borraDelCarrito(@PathVariable("idProducto") Long idProducto, Principal principal) {
        Producto productoAIntroducir = productoServicio.getProductoPorId(idProducto);
        Usuario usuario = usuarioServicio.buscarPorEmail(principal.getName());
        Carrito nuevoCarrito = usuario.getCarritoActivo();
        nuevoCarrito.removeProducto(productoAIntroducir);
        usuarioServicio.guardaCambios(usuario);
        return "redirect:/cart";
    }

}
