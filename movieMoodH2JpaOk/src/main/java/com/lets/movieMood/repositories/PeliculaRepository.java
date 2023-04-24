package com.lets.movieMood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lets.movieMood.entities.Pelicula;

public interface PeliculaRepository extends JpaRepository <Pelicula, Integer>{

}
