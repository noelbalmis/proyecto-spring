package com.noel.proyecto.modelo;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "carritos")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @ManyToMany(mappedBy = "carritos", cascade = CascadeType.ALL)
    private List<Producto> productos;

    private String estado;

    private LocalDateTime fecha;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public String getFecha() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return fecha.format(formatter);
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Carrito() {
        this.estado = "carrito";
    }

    public Carrito(Usuario usuario, List<Producto> productos, String estado) {
        this.usuario = usuario;
        this.productos = productos;
        this.estado = estado;
    }

    public void addProducto(Producto producto) {
        producto.getCarritos().add(this);
    }

    public void removeProducto(Producto producto) {
        producto.getCarritos().remove(this);
    }

    public void vaciarCarrito() {
        this.productos.clear();
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getPrecioTotal() {
        Double precioTotal = 0.0;
        for (Producto producto : this.productos) {
            precioTotal += producto.getPrecioUnitario();
        }
        return precioTotal;
    }

    public String getPrecioTotalFormateado() {
        DecimalFormatSymbols symbols = DecimalFormatSymbols.getInstance();
        symbols.setDecimalSeparator('.');

        DecimalFormat decimalFormat = new DecimalFormat("#.00", symbols);
        return decimalFormat.format(getPrecioTotal());
    }

    @Override
    public String toString() {
        return "Carrito [id=" + id + ", usuario=" + usuario.getId() + ", productos=" + productos + "]";
    }

}
