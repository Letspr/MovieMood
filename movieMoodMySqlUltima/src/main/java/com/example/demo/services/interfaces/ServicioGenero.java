
package com.example.demo.services.interfaces;

import java.util.List;

import com.example.demo.entities.Genero;
import com.example.demo.exceptions.ServicioException;

public interface ServicioGenero {

	List<Genero> listGeneros() throws ServicioException;

	Genero conseguirGenero(Integer idGenero) throws ServicioException;

}
