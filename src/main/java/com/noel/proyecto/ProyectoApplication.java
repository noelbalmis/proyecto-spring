package com.noel.proyecto;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.noel.proyecto.modelo.Categoria;
import com.noel.proyecto.modelo.Producto;
import com.noel.proyecto.modelo.Usuario;
import com.noel.proyecto.repositorio.CategoriaRepository;
import com.noel.proyecto.repositorio.ProductoRepository;
import com.noel.proyecto.servicios.UsuarioServicio;

@SpringBootApplication
public class ProyectoApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProyectoApplication.class, args);
  }

  @Bean
  CommandLineRunner initData(ProductoRepository productoRepositorio, CategoriaRepository categoriaRepositorio, UsuarioServicio usuarioServicio)
   {
    return args -> {
      /*
    
      Categoria categoria1 = new Categoria();
      categoria1.setNombre("Masterclases");
      categoriaRepositorio.save(categoria1);

      Categoria categoria2 = new Categoria();
      categoria2.setNombre("Cursos");
      categoriaRepositorio.save(categoria2);

      Categoria categoria3 = new Categoria();
      categoria3.setNombre("Conferencias");
      categoriaRepositorio.save(categoria3);

      Producto producto1 = new Producto();
      producto1.setNombre("Guía completa de burpees");
      producto1.setPrecioUnitario(19.99);
      producto1.setImagen("/productos/1.png");
      producto1.setDescripcion(
        "La guía completa de burpees es el recurso definitivo para aprender todo lo que necesitas saber sobre el ejercicio de burpees. Desde las técnicas básicas hasta las variantes avanzadas, este libro te guiará a través de un entrenamiento efectivo y divertido."
      );
      producto1.setCategoria(categoria2);
      productoRepositorio.save(producto1);

      Producto producto2 = new Producto();
      producto2.setNombre("Genera 10K/Mes desde tu casa");
      producto2.setPrecioUnitario(29.99);
      producto2.setImagen("/productos/2.png");
      producto2.setDescripcion(
        "¿Te gustaría generar un ingreso mensual de $10,000 desde la comodidad de tu hogar? Nuestro curso\"Genera 10K/Mes desde tu casa\" te proporciona las estrategias y herramientas necesarias para lograrlo. Descubre cómo transformar tus sueños en realidad."
      );
      producto2.setCategoria(categoria1);
      productoRepositorio.save(producto2);

      Producto producto3 = new Producto();
      producto3.setNombre("Mi historia personal");
      producto3.setPrecioUnitario(14.99);
      producto3.setImagen("/productos/3.png");
      producto3.setDescripcion(
        "Mi historia personal es un relato inspirador de superación y éxito. En este libro, comparto mis experiencias, desafíos y lecciones aprendidas en el camino hacia el logro de mis metas. Una historia que te motivará a perseguir tus propios sueños."
      );
      producto3.setCategoria(categoria3);
      productoRepositorio.save(producto3);

      Producto producto4 = new Producto();
      producto4.setNombre("Elimina tu panza rápido");
      producto4.setPrecioUnitario(39.99);
      producto4.setImagen("/productos/4.png");
      producto4.setDescripcion(
        "¿Quieres eliminar tu panza de forma rápida y eficaz? Nuestro programa \"Elimina tu panza rápido\" te ofrece un enfoque integral para lograrlo. Incluye consejos de nutrición, ejercicios efectivos y mucho más."
      );
      producto4.setCategoria(categoria1);
      productoRepositorio.save(producto4);

      Producto producto5 = new Producto();
      producto5.setNombre("Consigue un lambo gratis");
      producto5.setPrecioUnitario(9.99);
      producto5.setImagen("/productos/5.png");
      producto5.setDescripcion(
        "Consigue un Lamborghini de forma gratuita siguiendo nuestros secretos de éxito probados. Descubre estrategias y tácticas que te permitirán alcanzar tus objetivos financieros y tener el coche de tus sueños sin gastar un centavo."
      );
      producto5.setCategoria(categoria2);
      productoRepositorio.save(producto5);

      Producto producto6 = new Producto();
      producto6.setNombre("Charla privada conmigo");
      producto6.setPrecioUnitario(99.99);
      producto6.setImagen("/productos/6.png");
      producto6.setDescripcion(
        "Obtén una charla privada conmigo para discutir tus metas personales y profesionales. Recibirás orientación y consejos personalizados para alcanzar el éxito en tus emprendimientos y proyectos."
      );
      producto6.setCategoria(categoria3);
      productoRepositorio.save(producto6);

      Producto producto7 = new Producto();
      producto7.setNombre("Empieza tu primer negocio online");
      producto7.setPrecioUnitario(19.99);
      producto7.setImagen("/productos/7.png");
      producto7.setDescripcion(
        "Empieza tu primer negocio en línea con confianza y éxito. Nuestro curso te proporcionará los conocimientos y recursos necesarios para lanzar y hacer crecer tu negocio en el mundo digital."
      );
      producto7.setCategoria(categoria1);
      productoRepositorio.save(producto7);

      Producto producto8 = new Producto();
      producto8.setNombre("Plan de entrenamiento personalizado");
      producto8.setPrecioUnitario(39.99);
      producto8.setImagen("/productos/8.png");
      producto8.setDescripcion(
        "Obtén un plan de entrenamiento personalizado diseñado específicamente para ti. Nuestros entrenadores expertos trabajarán contigo para ayudarte a alcanzar tus objetivos de fitness y bienestar."
      );
      producto8.setCategoria(categoria2);
    productoRepositorio.save(producto8);  
      */

  };
  }
}
