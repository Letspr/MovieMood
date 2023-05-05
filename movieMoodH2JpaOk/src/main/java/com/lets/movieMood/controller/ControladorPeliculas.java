package com.lets.movieMood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lets.movieMood.entities.Pelicula;
import com.lets.movieMood.exceptions.ServicioException;
import com.lets.movieMood.services.interfaces.ServicioPelicula;

@Controller
@RequestMapping("/")
public class ControladorPeliculas extends ControladorError {
	
	@Autowired
	ServicioPelicula servicio;
	
		
	@GetMapping("/cartelera")
	public String paginaPeliculas (Model model) throws ServicioException {
		List<Pelicula> peliculas= servicio.listPeliculas();
		model.addAttribute("peliculas",peliculas);
		return "peliculas";
		
	}
	
	@GetMapping("/{id}")
	// path variable porque no puede coincidir la url
	public String paginaPelicula(@PathVariable Integer id,Model model) throws Exception {
		// Model model es un objeto que nos da Spring para meter atributos en la vista. Va a ser independiente para cada método.
		// Nuevo para cada método. Son maleteros diferentes.
		Pelicula pelicula = servicio.conseguirPelicula(id);
		
		model.addAttribute("pelicula", pelicula);	
		return "pelicula";
	}
	
	
	@GetMapping("/crearPelicula")
	public String paginaCrearPelicula (Model model) {
		return "crearPelicula";
		
	}
	
	@PostMapping("/crearPelicula")
	public String crearPelicula(@ModelAttribute Pelicula pelicula, Model model) throws Exception {
		
		pelicula=servicio.grabarPelicula(pelicula);
		model.addAttribute("pelicula", pelicula);
		return "crearPelicula";
	}
	
}
