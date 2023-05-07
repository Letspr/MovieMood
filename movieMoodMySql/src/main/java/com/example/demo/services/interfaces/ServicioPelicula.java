
package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.entities.Pelicula;
import com.example.demo.exceptions.ServicioException;



public interface ServicioPelicula  {
	
	List<Pelicula> listPeliculas() throws ServicioException;

	Pelicula conseguirPelicula(Integer idPelicula) throws ServicioException;

	Pelicula grabarPelicula(Pelicula pelicula) throws ServicioException;

	void eliminarPelicula(Integer idPelicula) throws ServicioException;

	List<Pelicula> listPeliculaQuery(String query) throws ServicioException;
	
	

}
