package com.example.demo.services.interfaces;

import com.example.demo.entities.PeliculaMM;
import com.example.demo.exceptions.ServicioException;
import com.example.demo.models.json.ImdbBusqueda;
import com.example.demo.models.json.ImdbPeliculaDetalle;

public interface ServicioIMDB {
	
	ImdbBusqueda busquedaPeliculas(String query)throws ServicioException;
	
	public ImdbPeliculaDetalle obtenerPelicula(String id)throws ServicioException;
	
	PeliculaMM toPeliculaMM (ImdbPeliculaDetalle peliculaIMDB) throws ServicioException;
}
