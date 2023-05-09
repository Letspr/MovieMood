package com.example.demo.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="PELICULAS")
public class PeliculaMM {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PELICULA_ID")
	private Integer id;
	@Column(name="TITULO")
	private String titulo;
	@Column(name="ANIO")
	private Integer anio;
	@Column(name="DIRECTOR")
	private String director;
	@Column(name="SINOPSIS", columnDefinition="TEXT")
	private String sinopsis;
	@Column(name="URL_CARATULA")
	private String urlCaratula;
	
	@ManyToMany
	@JoinTable(
	        name = "PELICULA_GENERO",
	        joinColumns = @JoinColumn(name = "PELICULA_ID"),
	        inverseJoinColumns = @JoinColumn(name = "GENERO_ID"))
	
	private List<Genero> generos;
	public PeliculaMM() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public String getUrlCaratula() {
		return urlCaratula;
	}

	public void setUrlCaratula(String urlCaratula) {
		this.urlCaratula = urlCaratula;
	}
	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", titulo=" + titulo + ", year=" + anio + ", director=" + director + ", sinopsis="
				+ sinopsis + ", urlCaratula=" + urlCaratula + "]";
	}

}
