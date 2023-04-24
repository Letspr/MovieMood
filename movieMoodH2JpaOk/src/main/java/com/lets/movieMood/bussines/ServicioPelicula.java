package com.lets.movieMood.bussines;

import java.util.List;

import com.lets.movieMood.entities.Pelicula;
import com.lets.movieMood.exceptions.ServicioException;



public interface ServicioPelicula {
	
	List<Pelicula> listPeliculas() throws ServicioException;

	Pelicula conseguirPelicula(Integer idPelicula) throws ServicioException;

	Pelicula grabarPelicula(Pelicula pelicula) throws ServicioException;

	void eliminarPelicula(Integer idPelicula) throws ServicioException;

	
	
	

}
