package com.example.demo.services.interfaces;

import com.example.demo.models.Template.BusquedaIMDB;
import com.example.demo.models.Template.PeliculaTMDBDetalle;

public interface ServicioIMDB {

	public BusquedaIMDB busquedaPeliculas(String query);
	public PeliculaTMDBDetalle obtenerPelicula(Integer id);
}
