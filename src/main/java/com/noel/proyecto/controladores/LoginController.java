package com.noel.proyecto.controladores;

import com.noel.proyecto.modelo.Usuario;
import com.noel.proyecto.servicios.UsuarioServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

  @Autowired
  UsuarioServicio usuarioServicio;

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/register")
  public String mostrarRegistro(Model model) {
    model.addAttribute("usuario", new Usuario());
    return "register";
  }

  @PostMapping("/register")
  public String register(@ModelAttribute Usuario usuario) {
    usuarioServicio.registrar(usuario);
    return "redirect:/login";
  }
}
