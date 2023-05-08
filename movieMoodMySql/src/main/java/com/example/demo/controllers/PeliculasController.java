package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Genero;
import com.example.demo.entities.Pelicula;
import com.example.demo.entities.models.EstadoPelicula;
import com.example.demo.exceptions.ServicioException;
import com.example.demo.models.Template.BusquedaIMDB;
import com.example.demo.models.Template.PeliculaTMDBDetalle;
import com.example.demo.services.interfaces.ServicioGenero;
import com.example.demo.services.interfaces.ServicioIMDB;
import com.example.demo.services.interfaces.ServicioPelicula;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class PeliculasController extends ErrorController {

	@Autowired
	ServicioPelicula servicioPelicula;
	
	@Autowired
	ServicioGenero servicioGenero;
	
	@Autowired
	ServicioIMDB servicioIMDB;
	
	
	@GetMapping("/cartelera")
	public String paginaPeliculas(Model model) throws ServicioException {
		List<Pelicula> peliculas = servicioPelicula.listPeliculas();
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("pagina", "cartelera");
		return "peliculas";

	}

	@GetMapping("/{id}")
	public String paginaPelicula(@PathVariable Integer id, Model model) throws Exception {
		Pelicula pelicula = servicioPelicula.conseguirPelicula(id);
		model.addAttribute("pagina", "cartelera");
		model.addAttribute("pelicula", pelicula);
		return "pelicula";
	}

	@GetMapping("/crearPelicula")
	public String paginaCrearPelicula(Model model) throws ServicioException {
		List<Genero> generos = servicioGenero.listGeneros();
		model.addAttribute("pelicula", new Pelicula());
		model.addAttribute("generos", generos);
		model.addAttribute("pagina", "crear");
		model.addAttribute("estado", EstadoPelicula.ninguno_crear);
		return "formulario";

	}

	@PostMapping("/crearPelicula")
	public String crearPelicula(@ModelAttribute Pelicula pelicula, Model model) throws Exception {

		pelicula = servicioPelicula.grabarPelicula(pelicula);
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("estado", EstadoPelicula.creado);
		model.addAttribute("pagina", "crear");
		return "formulario";
	}

	@GetMapping("/editar/{id}")
	public String editarPelicula(@PathVariable Integer id, Model model) throws Exception {
		Pelicula pelicula = servicioPelicula.conseguirPelicula(id);
		List<Genero> generos = servicioGenero.listGeneros();
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("generos", generos);
		model.addAttribute("estado", EstadoPelicula.ninguno_editar);

		return "formulario";
	}

	@PostMapping("/editar/crearPelicula")
	public String redirigiEditarPelicula(@ModelAttribute Pelicula pelicula, Model model) throws Exception {
		List<Genero> generos = servicioGenero.listGeneros();
		pelicula = servicioPelicula.grabarPelicula(pelicula);
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("estado", EstadoPelicula.editado);
		model.addAttribute("generos", generos);
		return "formulario";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarPelicula(@PathVariable Integer id, Model model) throws Exception {

		servicioPelicula.eliminarPelicula(id);

		return "redirect:/cartelera";
	}
	
	
	
	//Métodos del controlador para el ServicioTMDB
	
	@PostMapping("/busqueda")
	public String buscarPeliculas(HttpServletRequest request, @RequestParam String busqueda, Model model) throws ServicioException {
		
		if (request.getParameter("busquedaImdb") != null) {
			BusquedaIMDB busquedaIMDB = servicioIMDB.busquedaPeliculas(busqueda);
			model.addAttribute("peliculasTMDB", busquedaIMDB);
			return "peliculasTMDB";
		}
		List<Pelicula> misPeliculas = servicioPelicula.listPeliculaQuery(busqueda);
		model.addAttribute("peliculas", misPeliculas);
		return "peliculas";
				
	}
	
	@GetMapping("/busqueda/{id}")
	public String buscarPelicula(Model model,@PathVariable Float id) {
		
		PeliculaTMDBDetalle pelicula = servicioIMDB.obtenerPelicula(null);
		model.addAttribute("pelicula", pelicula);
		return "peliculaTMDB";
	}

}
