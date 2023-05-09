
package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.entities.PeliculaMM;
import com.example.demo.exceptions.ServicioException;

public interface ServicioPelicula {

	List<PeliculaMM> listPeliculas() throws ServicioException;

	PeliculaMM conseguirPelicula(Integer idPelicula) throws ServicioException;

	PeliculaMM grabarPelicula(PeliculaMM pelicula) throws ServicioException;

	void eliminarPelicula(Integer idPelicula) throws ServicioException;

	List<PeliculaMM> listPeliculaQuery(String query) throws ServicioException;

}
