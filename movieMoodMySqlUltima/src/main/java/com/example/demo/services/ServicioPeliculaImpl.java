package com.example.demo.services;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.PeliculaMM;
import com.example.demo.exceptions.CodeError;
import com.example.demo.exceptions.ServicioException;
import com.example.demo.repositories.PeliculaRepository;
import com.example.demo.services.interfaces.ServicioPelicula;

@Service
public class ServicioPeliculaImpl implements ServicioPelicula{
	
	Logger log = LoggerFactory.getLogger(ServicioPeliculaImpl.class);
	
	@Autowired
	PeliculaRepository peliculaRepository;

	@Override
	public List<PeliculaMM> listPeliculas() throws ServicioException {
		log.info("[listPeliculas]");
		
		List<PeliculaMM> peliculas;
		
		try {
			peliculas=peliculaRepository.findAll();
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL, e);
		}
		return peliculas;
	}
	
	public List<PeliculaMM> listPeliculaQuery(String query) {
		List<PeliculaMM> peliculas;
		peliculas = peliculaRepository.findByTituloContainingIgnoreCaseOrDirectorContainingIgnoreCaseOrSinopsisContainingIgnoreCase(query,query,query);
		return peliculas.stream().filter(t -> t != null).toList();
	}

	@Override
	public PeliculaMM conseguirPelicula(Integer idPelicula) throws ServicioException {
		log.info("[conseguirPelicula]");
		log.debug("[idPelicula: "+idPelicula+"]");
		
		PeliculaMM pelicula;
		
		try {
			Optional<PeliculaMM> peliculaOp=peliculaRepository.findById(idPelicula);
			if(!peliculaOp.isPresent())throw new ServicioException(CodeError.PELICULA_NOT_FOUND);
			pelicula=peliculaOp.get();
			
		}catch(ServicioException se) {
			log.error("ServicioException", se);
			throw se;
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return pelicula;
	}

	@Override
	public PeliculaMM grabarPelicula(PeliculaMM pelicula) throws ServicioException {
		log.info("[grabarPelicula]");
		log.debug("[pelicula: "+pelicula.toString()+"]");
		
		try {
			pelicula=peliculaRepository.save(pelicula);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return pelicula;
	}

	@Override
	public void eliminarPelicula(Integer idPelicula) throws ServicioException {
		log.info("[eliminarPelicula]");
		log.debug("[idPelicula: "+idPelicula+"]");
		
			try {
			peliculaRepository.deleteById(idPelicula);
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		
	}

	
}
