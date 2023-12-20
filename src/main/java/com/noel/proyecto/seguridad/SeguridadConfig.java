package com.noel.proyecto.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SeguridadConfig {

	@Autowired
	UserDetailsService userDetailsService;
	
	//Algoritmo de cifrado
	@Bean
    protected BCryptPasswordEncoder getPassWordEncoder() {
        return new BCryptPasswordEncoder();
    }
	

	@Bean
	protected DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(getPassWordEncoder());
		return authProvider;
	}
	/*
	@Bean
	protected AuthenticationManager authentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(getPassWordEncoder());
		return auth.build();
	}
	*/
	
	

	@Bean
	protected SecurityFilterChain filter(HttpSecurity http) throws Exception {
		
		http
			.authorizeHttpRequests(auth -> auth
				.requestMatchers(AntPathRequestMatcher.antMatcher("/register/**")).permitAll()
				.requestMatchers(AntPathRequestMatcher.antMatcher("/webjars/**")).permitAll()
				.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
				.requestMatchers(AntPathRequestMatcher.antMatcher("/images/**")).permitAll()
				.anyRequest().authenticated() // Cualquier otra ruta requerirá autenticación
				)
			.formLogin(login -> login.loginPage("/login") //Página por defecto login
									.defaultSuccessUrl("/", true) //Si el login es correcto, página por defecto
									.loginProcessingUrl("/login") // Controlador que manejará la autenticación. Lo implementa Spring Security
									.permitAll() //
					)
			.logout(logout -> logout
									.logoutUrl("/logout") // Cuanto mandemos al usuario a esta ruta en POST se deslogueará automáticamente
									.logoutSuccessUrl("/index")	//Cuando se desloguee
			
					)
			//Esto son opciones de seguridad que quitamos necesarias para acceder a H2 console
			.csrf(csrf -> csrf.disable())
			.headers(headers -> headers.frameOptions( frame -> frame.disable())
			);
									
		
		return http.build();
	}
}
