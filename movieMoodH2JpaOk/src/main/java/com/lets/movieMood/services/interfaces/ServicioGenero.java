
package com.lets.movieMood.services.interfaces;

import java.util.List;

import com.lets.movieMood.entities.Genero;
import com.lets.movieMood.exceptions.ServicioException;



public interface ServicioGenero  {
	
	List<Genero> listGeneros() throws ServicioException;

	Genero conseguirGenero(Integer idGenero) throws ServicioException;

	Genero grabarGenero(Genero genero) throws ServicioException;

	void eliminarGenero(Integer idGenero) throws ServicioException;

	
	
	

}
