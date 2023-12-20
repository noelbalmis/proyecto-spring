package com.noel.proyecto.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.noel.proyecto.modelo.Carrito;
import com.noel.proyecto.modelo.Usuario;
import com.noel.proyecto.repositorio.UsuarioRepository;

@Service
public class UsuarioServicio {
    
    @Autowired
    UsuarioRepository usuarioRepositorio;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public Usuario registrar(Usuario u) {
        u.setClave(passwordEncoder.encode(u.getClave()));
        Carrito carrito = new Carrito();
    	carrito.setUsuario(u);
    	u.addCarritoActivo(carrito);
        return usuarioRepositorio.save(u);
    }

    public Usuario findById(long id) {
        return usuarioRepositorio.findById(id).orElse(null);
    }

    public Usuario buscarPorEmail(String email) {
        return usuarioRepositorio.findFirstByEmail(email);
    }

    public Usuario guardaCambios(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public void creaCarritoActivo(Usuario usuario) {
        Carrito carrito = new Carrito();
        carrito.setUsuario(usuario);
        usuario.addCarritoActivo(carrito);
    }
}
