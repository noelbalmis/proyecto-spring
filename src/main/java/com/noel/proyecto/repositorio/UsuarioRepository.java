package com.noel.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.noel.proyecto.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findFirstByEmail(String email);
}
