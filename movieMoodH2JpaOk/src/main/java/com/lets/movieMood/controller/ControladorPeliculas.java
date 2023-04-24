package com.lets.movieMood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lets.movieMood.bussines.ServicioPelicula;
import com.lets.movieMood.entities.Pelicula;
import com.lets.movieMood.exceptions.ServicioException;

@Controller
@RequestMapping("/")
public class ControladorPeliculas {
	
	@Autowired
	ServicioPelicula servicio;
	
	@GetMapping("/cartelera")
	public String paginaPeliculas (Model model) throws ServicioException {
		List<Pelicula> peliculas= servicio.listPeliculas();
		model.addAttribute("peliculas",peliculas);
		return "peliculas";
		
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
