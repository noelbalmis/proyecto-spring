package com.noel.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noel.proyecto.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNombre(String nombre);
}
