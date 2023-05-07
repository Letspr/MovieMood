package com.example.demo.services.interfaces;

import com.example.demo.models.BusquedaIMDB;

public interface ServicioIMDB {

	public BusquedaIMDB busquedaPeliculas(String query);
	public void obtenerPelicula(Integer id);
}
