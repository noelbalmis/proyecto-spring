package com.noel.proyecto.controladores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.noel.proyecto.modelo.Categoria;
import com.noel.proyecto.modelo.Producto;
import com.noel.proyecto.servicios.CategoriaServicio;
import com.noel.proyecto.servicios.ProductoServicio;
import com.noel.proyecto.servicios.UsuarioServicio;

@Controller
public class AdminZoneController {

    @Autowired
    ProductoServicio productoServicio;

    @Autowired
    CategoriaServicio categoriaServicio;

    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/adminzone")
    public String mostrarZonaAdmin(Model model) {
        model.addAttribute("productos", productoServicio.getAllProductos());
        model.addAttribute("categorias", categoriaServicio.getAllCategorias());
        return "adminzone";
    }

    @PostMapping("/createproduct")
    public String creaProducto(@RequestParam String nombre, @RequestParam String descripcion,
            @RequestParam Double precioUnitario, @RequestParam String categoria, @RequestParam MultipartFile imagen) {
        String rutaImagen = "";
        try {
            String fileName = imagen.getOriginalFilename();
            rutaImagen = "/productos/" + fileName;
            String rutaAbsoluta = "src/main/resources/static" + rutaImagen;

            Files.copy(imagen.getInputStream(), Paths.get(rutaAbsoluta), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Producto producto = new Producto(nombre, precioUnitario, rutaImagen, descripcion,
                categoriaServicio.findByNombre(categoria));
        productoServicio.guardaProducto(producto);
        return "redirect:/adminzone";
    }

    @PostMapping("/deleteproduct")
    public String borraProducto(@RequestParam Long id) {
        productoServicio.borraProducto(id);
        return "redirect:/adminzone";
    }

    @PostMapping("/createcategory")
    public String creaCategoria(@RequestParam String nombreCategoria) {
        Categoria categoria = new Categoria(nombreCategoria);
        categoriaServicio.guardaCategoria(categoria);
        return "redirect:/adminzone";
    }

    @PostMapping("/deletecategory")
    public String borraCategoria(@RequestParam Long id) {
        categoriaServicio.borraCategoria(id);
        return "redirect:/adminzone";
    }

}
