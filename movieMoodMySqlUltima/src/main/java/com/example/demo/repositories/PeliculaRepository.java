package com.example.demo.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.PeliculaMM;

public interface PeliculaRepository extends JpaRepository <PeliculaMM, Integer>{
	List<PeliculaMM> findByTituloContainingIgnoreCaseOrDirectorContainingIgnoreCaseOrSinopsisContainingIgnoreCase(String titulo, String director, String sinopsis);

}
