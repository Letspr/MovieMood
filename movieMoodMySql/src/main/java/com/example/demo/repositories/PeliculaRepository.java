package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Pelicula;

public interface PeliculaRepository extends JpaRepository <Pelicula, Integer>{
	List<Pelicula> findByTituloContainingIgnoreCaseOrDirectorContainingIgnoreCaseOrSinopsisContainingIgnoreCase(String titulo, String director, String sinopsis);

}
