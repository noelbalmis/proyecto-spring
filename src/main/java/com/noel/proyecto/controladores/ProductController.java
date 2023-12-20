package com.noel.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.noel.proyecto.modelo.Producto;
import com.noel.proyecto.servicios.CategoriaServicio;
import com.noel.proyecto.servicios.ProductoServicio;
import com.noel.proyecto.servicios.UsuarioServicio;

@Controller
public class ProductController {

    @Autowired
    ProductoServicio productoServicio;

    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    CategoriaServicio categoriaServicio;

    @GetMapping("/product/{id}")
    public String muestraProducto(@PathVariable("id") Long id, Model model) {
        Producto producto = productoServicio.getProductoPorId(id);
        model.addAttribute("producto", producto);
        return "product";
    }
}
