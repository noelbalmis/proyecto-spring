package com.noel.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.noel.proyecto.modelo.Carrito;
import com.noel.proyecto.modelo.Usuario;
import com.noel.proyecto.repositorio.CarritoRepository;

@Service
public class CarritoServicio {
    @Autowired
    private CarritoRepository carritoRepository;

    public int getNumeroProductos(Carrito carrito) {
        return carrito.getProductos().size();
    }

    public Carrito vaciarCarrito(Carrito carrito) {
        carrito.vaciarCarrito();
        return carritoRepository.save(carrito);
    }

    public Carrito guardaCambios(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    public List<Carrito> obtenerCarritosPorEstado(String estado) {
        return carritoRepository.findByEstado(estado);
    }

    public Carrito findById(Long id) {
        return carritoRepository.findById(id).orElse(null);
    }
}
