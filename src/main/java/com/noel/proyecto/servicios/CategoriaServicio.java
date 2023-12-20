package com.noel.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.noel.proyecto.modelo.Categoria;
import com.noel.proyecto.repositorio.CategoriaRepository;

@Service
public class CategoriaServicio {
    @Autowired
    CategoriaRepository categoriaRepositorio;

    public List<Categoria> getAllCategorias() {
        return categoriaRepositorio.findAll();
    }

    public Categoria findByNombre(String nombre) {
        return categoriaRepositorio.findByNombre(nombre);
    }

    public void guardaCategoria(Categoria categoria) {
        categoriaRepositorio.save(categoria);
    }

    public void borraCategoria(Long id) {
        categoriaRepositorio.deleteById(id);
    }
}
