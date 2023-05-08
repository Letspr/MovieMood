package com.example.demo.services.interfaces;

import com.example.demo.exceptions.ServicioException;
import com.example.demo.models.Template.BusquedaTMDB;
import com.example.demo.models.Template.PeliculaTMDBDetalle;

public interface ServicioTMDB {

	public BusquedaTMDB busquedaPeliculas(String query)throws ServicioException;
	public PeliculaTMDBDetalle obtenerPelicula(Float id)throws ServicioException;
}
