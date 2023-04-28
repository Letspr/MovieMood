package com.lets.movieMood.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.lets.movieMood.entities.Genero;
import com.lets.movieMood.entities.GeneroPeliculas;
import com.lets.movieMood.entities.Pelicula;

public interface GeneroPeliculaRepository extends JpaRepository <GeneroPeliculas, Integer>{

	@Query("Select gp.pelicula from GeneroPeliculas gp from gp.genero.id=:idGenero")
	List<Pelicula> buscarPorGenero(Integer idGenero);
	
	@Query("Select gp.genero from GeneroPeliculas gp from gp.pelicula.id=:idPelicula")
	List<Genero> buscarPorPeliculas(Integer idPelicula);
	
	
	
}
