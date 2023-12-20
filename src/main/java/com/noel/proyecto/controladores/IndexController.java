package com.noel.proyecto.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.noel.proyecto.modelo.Categoria;
import com.noel.proyecto.modelo.Producto;
import com.noel.proyecto.servicios.CarritoServicio;
import com.noel.proyecto.servicios.CategoriaServicio;
import com.noel.proyecto.servicios.ProductoServicio;
import com.noel.proyecto.servicios.UsuarioServicio;

@Controller
public class IndexController {

    @Autowired
    ProductoServicio productoServicio;

    @Autowired
    CategoriaServicio categoriaServicio;

    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    CarritoServicio carritoServicio;

    @GetMapping("/")
    public String principal(Model model) {
        model.addAttribute("productos", productoServicio.getAllProductos());
        model.addAttribute("categorias", categoriaServicio.getAllCategorias());
        return "index";
    }

    @PostMapping("/")
    public String filtrarProductos(
            @RequestParam(name = "categoria") String nombreCategoria,
            @RequestParam(name = "precio") String filtroPrecio,
            @RequestParam(name = "busqueda") String textoBusqueda,
            Model model) {
        List<Producto> productosFiltrados = new ArrayList<Producto>();
        if (nombreCategoria.equals("todas")) {
            productosFiltrados = productoServicio.getAllProductosPorPrecio(filtroPrecio);
        } else {
            Categoria categoria = categoriaServicio.findByNombre(nombreCategoria);
            productosFiltrados = productoServicio.getProductosByCategoriaAndPrecio(categoria, filtroPrecio);
        }

        if (!textoBusqueda.isEmpty()) {
            productosFiltrados = productoServicio.filtrarProductosPorTexto(productosFiltrados, textoBusqueda);
        }

        model.addAttribute("productos", productosFiltrados);
        model.addAttribute("categorias", categoriaServicio.getAllCategorias());
        model.addAttribute("categoriaSeleccionada", nombreCategoria);
        model.addAttribute("filtroPrecioSeleccionado", filtroPrecio);
        return "index";
    }
}
