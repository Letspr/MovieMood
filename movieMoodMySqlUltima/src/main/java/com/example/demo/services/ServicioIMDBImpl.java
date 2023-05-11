package com.example.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.entities.PeliculaMM;
import com.example.demo.exceptions.CodeError;
import com.example.demo.exceptions.ServicioException;
import com.example.demo.models.json.ImdbBusqueda;
import com.example.demo.models.json.ImdbPeliculaDetalle;
import com.example.demo.services.interfaces.ServicioIMDB;

@Service
public class ServicioIMDBImpl implements ServicioIMDB {

	@Value("${imdb.api.baseUrl.real}")
	String baseUrl;
	@Value("${imdb.api.token.real}")
	String token;
	Logger log = LoggerFactory.getLogger(ServicioGeneroImpl.class);

	@Override
	public ImdbBusqueda busquedaPeliculas(String query) throws ServicioException {
		log.debug("busquedaPeliculas");

		RestTemplate restTemplate = new RestTemplate();

		try {
			// https://imdb-api.com/API/Search/k_2jm860cf/club
			String url = baseUrl + "Search/" + token + "/" + query;
			ResponseEntity<ImdbBusqueda> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<ImdbBusqueda>() {
					});

			log.debug("ImdbBusqueda:" + responseEntity);

			return responseEntity.getBody();
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_BUSQUEDA_IMDB, e);
		}

	}

	@Override
	public ImdbPeliculaDetalle obtenerPelicula(String id) throws ServicioException {
		log.debug("obtenerPelicula");

		RestTemplate restTemplate = new RestTemplate();

		try {
			// https://imdb-api.com/es/API/Title/k_2jm860cf/tt0137523/Wikipedia
			String url = baseUrl + "Title/" + token + "/" + id + "/Wikipedia";

			ImdbPeliculaDetalle pelicula = restTemplate.getForObject(url, ImdbPeliculaDetalle.class);

			log.debug("pelicula:" + pelicula);

			return pelicula;
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_BUSQUEDA_TMDB, e);
		}

	}
	
	@Override
	public PeliculaMM toPeliculaMM(ImdbPeliculaDetalle peliculaIMDB) throws ServicioException {
		log.info("[toPeliculaMM]");
		log.debug("[peliculaIMDB: "+peliculaIMDB+"]");
		
		try {
		PeliculaMM peliculaMM = new PeliculaMM();
		peliculaMM.setTitulo(peliculaIMDB.getTitle());
		peliculaMM.setAnio(Integer.parseInt(peliculaIMDB.getYear()));
		peliculaMM.setDirector(peliculaIMDB.getDirectoresName());
		peliculaMM.setSinopsis(peliculaIMDB.getPlotLocal());
		peliculaMM.setUrlCaratula(peliculaIMDB.getImage());
		
		log.debug("[peliculaMM: "+peliculaMM+"]");
		
		return peliculaMM;
		
		} catch(Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_MAPEO_IMDB_MM,e);
		} 					
	
	}

}
