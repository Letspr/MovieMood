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
import com.example.demo.entities.PeliculaMM;
import com.example.demo.entities.models.EstadoPelicula;
import com.example.demo.exceptions.ServicioException;
import com.example.demo.models.json.BusquedaTMDB;
import com.example.demo.models.json.ImdbBusqueda;
import com.example.demo.models.json.ImdbPeliculaDetalle;
import com.example.demo.models.json.PeliculaTMDBDetalle;
import com.example.demo.services.interfaces.ServicioGenero;
import com.example.demo.services.interfaces.ServicioIMDB;
import com.example.demo.services.interfaces.ServicioTMDB;
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
	ServicioTMDB servicioTMDB;
	
	@Autowired
	ServicioIMDB servicioIMDB;
	
	
	@GetMapping("/cartelera")
	public String paginaPeliculas(Model model) throws ServicioException {
		List<PeliculaMM> peliculas = servicioPelicula.listPeliculas();
		model.addAttribute("peliculas", peliculas);
		model.addAttribute("pagina", "cartelera");
		return "peliculas";

	}

	@GetMapping("/{id}")
	public String paginaPelicula(@PathVariable Integer id, Model model) throws Exception {
		PeliculaMM pelicula = servicioPelicula.conseguirPelicula(id);
		model.addAttribute("pagina", "cartelera");
		model.addAttribute("pelicula", pelicula);
		return "pelicula";
	}

	@GetMapping("/crearPelicula")
	public String paginaCrearPelicula(Model model) throws ServicioException {
		List<Genero> generos = servicioGenero.listGeneros();
		model.addAttribute("pelicula", new PeliculaMM());
		model.addAttribute("generos", generos);
		model.addAttribute("pagina", "crear");
		model.addAttribute("estado", EstadoPelicula.ninguno_crear);
		return "formulario";

	}

	@PostMapping("/crearPelicula")
	public String crearPelicula(@ModelAttribute PeliculaMM pelicula, Model model) throws Exception {

		pelicula = servicioPelicula.grabarPelicula(pelicula);
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("estado", EstadoPelicula.creado);
		model.addAttribute("pagina", "crear");
		return "formulario";
	}

	@GetMapping("/editar/{id}")
	public String editarPelicula(@PathVariable Integer id, Model model) throws Exception {
		PeliculaMM pelicula = servicioPelicula.conseguirPelicula(id);
		List<Genero> generos = servicioGenero.listGeneros();
		model.addAttribute("pelicula", pelicula);
		model.addAttribute("generos", generos);
		model.addAttribute("estado", EstadoPelicula.ninguno_editar);

		return "formulario";
	}

	@PostMapping("/editar/crearPelicula")
	public String redirigiEditarPelicula(@ModelAttribute PeliculaMM pelicula, Model model) throws Exception {
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
	
	
	
	//-------------------Métodos del controlador para el ServicioTMDB--------------------
	
	@PostMapping("/busquedaTMDB")
	public String buscarPeliculasTMDB(HttpServletRequest request, @RequestParam String busqueda, Model model) throws ServicioException {
		
		if (request.getParameter("busquedaAPI") != null) {
			BusquedaTMDB busquedaIMDB = servicioTMDB.busquedaPeliculas(busqueda);
			model.addAttribute("peliculasTMDB", busquedaIMDB);
			return "peliculasTMDB";
		}
		List<PeliculaMM> misPeliculas = servicioPelicula.listPeliculaQuery(busqueda);
		model.addAttribute("peliculas", misPeliculas);
		return "peliculas";
				
	}
	
	@GetMapping("/busquedaTMDB/{id}")
	public String buscarPeliculaTMDB(Model model,@PathVariable Float id) throws ServicioException {
		
		PeliculaTMDBDetalle pelicula = servicioTMDB.obtenerPelicula(id);
		model.addAttribute("pelicula", pelicula);
		return "peliculaTMDB";
	}
	
	
	//-----------------------Métodos del controlador para el ServicioIMDB------------------------
	
	@PostMapping("/busquedaIMDB")
	public String buscarPeliculasIMDB(HttpServletRequest request, @RequestParam String busqueda, Model model) throws ServicioException {
		
		if (request.getParameter("busquedaAPI") != null) {
			ImdbBusqueda busquedaIMDB = servicioIMDB.busquedaPeliculas(busqueda);
			model.addAttribute("peliculasIMDB", busquedaIMDB);
			return busquedaIMDB.getResults().size() >0?"peliculasIMDB":"notFoundIMDB";
		}
		List<PeliculaMM> misPeliculas = servicioPelicula.listPeliculaQuery(busqueda);
		model.addAttribute("peliculas", misPeliculas);
		return misPeliculas.size() >0? "peliculas": "notFound";
				
	}
	
	@GetMapping("/busquedaIMDB/{id}")
	public String buscarPeliculaIMDB(Model model, @PathVariable String id) throws ServicioException {
		
		ImdbPeliculaDetalle pelicula = servicioIMDB.obtenerPelicula(id);
		model.addAttribute("pelicula", pelicula);
		return "peliculaIMDB";
	}
	
	
	@GetMapping("/guardarMM/{id}")
	public String guardarEnNN(Model model, @PathVariable String id) throws ServicioException{
		ImdbPeliculaDetalle pelicula = servicioIMDB.obtenerPelicula(id);
		PeliculaMM peliculaMM=servicioIMDB.toPeliculaMM(pelicula);
		model.addAttribute("pelicula", peliculaMM);
		return "formularioIMDB";
	}
	
	
	
//	@GetMapping("/busquedaIMDB/{id}")
//	public String buscarPeliculaIMDB(HttpServletRequest request, Model model, @PathVariable String id) throws ServicioException {
//		
//		ImdbPeliculaDetalle pelicula = servicioIMDB.obtenerPelicula(id);
//		
//		
//		if (request.getParameter("guardarMM") != null) {
//		model.addAttribute("pelicula", pelicula);
//		return "peliculaIMDB";
//		}
//		
//		servicioIMDB.toPeliculaMM(pelicula);
//		model.addAttribute("pelicula", pelicula);
//		model.addAttribute("estado", EstadoPelicula.ninguno_añadir);
//		return "formulario";
//	}
	
	


}
