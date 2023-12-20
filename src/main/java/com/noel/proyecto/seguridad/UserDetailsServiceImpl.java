package com.noel.proyecto.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.noel.proyecto.modelo.Usuario;
import com.noel.proyecto.repositorio.UsuarioRepository;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UsuarioRepository repositorio;
	
	//Se ejecuta al iniciar sesión
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = repositorio.findFirstByEmail(username);
		UserBuilder builder = null;
		
		if (usuario != null) {
			builder = User.withUsername(username); // Le damos el usuario
			builder.disabled(false);
			builder.password(usuario.getClave()); // Y le damos la contraseña
			builder.authorities(new SimpleGrantedAuthority("ROLE_USER")); // Autoridades por defecto
		}else {
			throw new UsernameNotFoundException("Usuario no encontraod");
		}
		
		return builder.build();
	}

}
