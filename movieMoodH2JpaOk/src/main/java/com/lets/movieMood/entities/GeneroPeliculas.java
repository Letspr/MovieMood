package com.lets.movieMood.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="GENEROPELICULAS")

//TODO: preguntar el th:object="${pelicula/departamento}"
public class GeneroPeliculas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="GENEROPELICULA_ID")
	private Integer id;

	@ManyToOne()
	@JoinColumn(name="GENERO_ID")
	private Genero genero;
	
	@ManyToOne()
	@JoinColumn(name="PELICULA_ID")
	private Pelicula pelicula;
	
	
	public GeneroPeliculas() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
