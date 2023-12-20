package com.noel.proyecto.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "clave")
    private String clave;

    @Column(name = "rol")
    private String rol;

    @Column(name = "dni", unique = true)
    private String dni;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @OneToMany(mappedBy="usuario", cascade = CascadeType.ALL)
    private List<Carrito> carritos = new ArrayList<Carrito>();

    public Usuario () { }

    public Usuario(String email, String clave) {
        this.email = email;
        this.clave = clave;
    }

	public Usuario(Long id, String nombre, String apellidos, String email, String clave, String rol, String dni,
			String direccion, String telefono, List<Carrito> carritos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.clave = clave;
		this.rol = rol;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.carritos = carritos;
	}

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public void addCarritoActivo(Carrito c) {
		carritos.add(c);
	}
	
	public Carrito getCarritoActivo() {
		
		for(Carrito c : carritos) {
			if(c.getEstado().equals("carrito"))
				return c;
		}
		return null;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Carrito> getCarrito() {
		return carritos;
	}

	public void setCarrito(List<Carrito> carritos) {
		this.carritos = carritos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email + ", clave="
				+ clave + ", rol=" + rol + ", dni=" + dni + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", carrito=" + carritos + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellidos, carritos, clave, direccion, dni, email, id, nombre, rol, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(carritos, other.carritos)
				&& Objects.equals(clave, other.clave) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(dni, other.dni) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(rol, other.rol)
				&& Objects.equals(telefono, other.telefono);
	}

    

   

    
}
