package com.noel.proyecto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noel.proyecto.modelo.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    List<Carrito> findByEstado(String estado);
}
