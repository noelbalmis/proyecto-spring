package com.noel.proyecto.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.noel.proyecto.modelo.Categoria;
import com.noel.proyecto.modelo.Producto;
import com.noel.proyecto.repositorio.ProductoRepository;

@Service
public class ProductoServicio {
    @Autowired
    ProductoRepository productoRepositorio;

    public Producto getProductoPorId(Long id) {
        return productoRepositorio.findById(id).orElse(null);
    }

    public List<Producto> getAllProductos() {
        return productoRepositorio.findAll();
    }

    public List<Producto> getAllProductosPorPrecio(String filtroPrecio) {
        Sort sort = obtenerOrdenacionPorPrecio(filtroPrecio);
        return productoRepositorio.findAll(sort);
    }

    public List<Producto> getProductosByCategoriaAndPrecio(Categoria categoria, String filtroPrecio) {
        Sort sort = obtenerOrdenacionPorPrecio(filtroPrecio);
        return productoRepositorio.findByCategoriaId(categoria.getId(), sort);
    }

    public List<Producto> filtrarProductosPorTexto(List<Producto> productos, String textoBusqueda) {
        List<Producto> productosFiltrados = new ArrayList<>();
        for (Producto producto : productos) {
            if (producto.getNombre().toLowerCase().contains(textoBusqueda.toLowerCase())) {
                productosFiltrados.add(producto);
            }
        }
        return productosFiltrados;
    }

    private Sort obtenerOrdenacionPorPrecio(String filtroPrecio) {
        if ("asc".equalsIgnoreCase(filtroPrecio)) {
            return Sort.by(Sort.Direction.ASC, "precioUnitario");
        } else if ("desc".equalsIgnoreCase(filtroPrecio)) {
            return Sort.by(Sort.Direction.DESC, "precioUnitario");
        } else {
            return Sort.unsorted();
        }
    }

    public void guardaProducto(Producto producto) {
        productoRepositorio.save(producto);
    }

    public void borraProducto(Long id) {
        productoRepositorio.deleteById(id);
    }
}
