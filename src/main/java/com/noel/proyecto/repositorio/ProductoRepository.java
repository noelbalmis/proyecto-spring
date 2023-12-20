package com.noel.proyecto.repositorio;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.noel.proyecto.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
    Producto findById(long id);
    List<Producto> findAll(Sort sort);
    List<Producto> findByCategoriaId(Long categoriaId, Sort sort);
}
