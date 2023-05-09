package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="GENEROS")

public class Genero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="GENERO_ID")
	private Integer id;
	@Column(name="NOMBRE")
	private String nombre;
	@ManyToMany(mappedBy = "generos")
	private List<PeliculaMM> peliculas;
	public Genero() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public List<PeliculaMM> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<PeliculaMM> peliculas) {
		this.peliculas = peliculas;
	}

	@Override
	public String toString() {
		return "Genero [id=" + id + ", nombre=" + nombre + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		return ((Genero)obj).id == id;
	}

	
	
}
