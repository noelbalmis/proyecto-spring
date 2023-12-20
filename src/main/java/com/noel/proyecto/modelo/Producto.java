package com.noel.proyecto.modelo;

import java.text.DecimalFormat;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre", unique = true)
  private String nombre;

  @Column(name = "precioUnitario")
  private Double precioUnitario;

  @Column(name = "imagen")
  private String imagen;

  @Column(name = "descripcion")
  private String descripcion;

  @ManyToOne
  private Categoria categoria;

  @ManyToMany(cascade = CascadeType.ALL)
  @JoinTable(name = "carrito_productos", joinColumns = @JoinColumn(name = "producto_id"), inverseJoinColumns = @JoinColumn(name = "carrito_id"))
  private List<Carrito> carritos;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public Double getPrecioUnitario() {
    return precioUnitario;
  }

  public String getPrecioFormateado() {
    DecimalFormat decimalFormat = new DecimalFormat("#.00");
    return decimalFormat.format(precioUnitario);
  }

  public void setPrecioUnitario(Double precioUnitario) {
    this.precioUnitario = precioUnitario;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Categoria getCategoria() {
    return categoria;
  }

  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  public List<Carrito> getCarritos() {
    return carritos;
  }

  public void setCarritos(List<Carrito> carritos) {
    this.carritos = carritos;
  }

  public Producto() {
  }

  public Producto(String nombre, Double precioUnitario, String imagen, String descripcion, Categoria categoria) {
    this.nombre = nombre;
    this.precioUnitario = precioUnitario;
    this.imagen = imagen;
    this.descripcion = descripcion;
    this.categoria = categoria;
  }

  @Override
  public String toString() {
    return "Producto [id=" + id + ", nombre=" + nombre + ", precioUnitario=" + precioUnitario + ", imagen=" + imagen
        + ", descripcion=" + descripcion + ", categoria=" + categoria.getId() + ", carritos="
        + carritos + "]";
  }

}
