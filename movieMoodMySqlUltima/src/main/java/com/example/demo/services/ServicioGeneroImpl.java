package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Genero;
import com.example.demo.exceptions.CodeError;
import com.example.demo.exceptions.ServicioException;
import com.example.demo.repositories.GeneroRepository;
import com.example.demo.services.interfaces.ServicioGenero;

@Service
public class ServicioGeneroImpl implements ServicioGenero {

	Logger log= LoggerFactory.getLogger(ServicioGeneroImpl.class);
	
	@Autowired
	GeneroRepository generoRepository;

	@Override
	public List<Genero> listGeneros() throws ServicioException {
		log.info("[listarGeneros]");
		
		List<Genero> generos;
		
		try {
			generos=generoRepository.findAll();
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL, e);
		}
		return generos;
	}

	@Override
	public Genero conseguirGenero(Integer idGenero) throws ServicioException {
		log.info("[conseguirGenero]");
		log.debug("[idGenero: "+idGenero+"]");
		
		Genero genero;

		try {
			Optional<Genero> generoOp=generoRepository.findById(idGenero);
			if(!generoOp.isPresent())throw new ServicioException(CodeError.GENERO_NOT_FOUND);
			genero=generoOp.get();
			
		}catch(ServicioException se) {
			log.error("ServicioException", se);
			throw se;
		}catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_GENERAL,e);
		}
		return genero;
	}

	
	
}