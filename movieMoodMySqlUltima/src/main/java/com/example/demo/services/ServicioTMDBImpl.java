package com.example.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.exceptions.CodeError;
import com.example.demo.exceptions.ServicioException;
import com.example.demo.models.json.BusquedaTMDB;
import com.example.demo.models.json.PeliculaTMDBDetalle;
import com.example.demo.services.interfaces.ServicioTMDB;

@Service
public class ServicioTMDBImpl implements ServicioTMDB {

	@Value("${imdb.api.baseUrl}")
	String baseUrl;
	@Value("${imdb.api.token}")
	String token;

	Logger log = LoggerFactory.getLogger(ServicioGeneroImpl.class);

	@Override
	public BusquedaTMDB busquedaPeliculas(String query) throws ServicioException {
		log.debug("busquedaPeliculas");

		RestTemplate restTemplate = new RestTemplate();

		try {
			String url = baseUrl + "search/movie?include_adult=false&language=en-US&page=1&query=" + query + "&api_key="
					+ token;
			ResponseEntity<BusquedaTMDB> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
					new ParameterizedTypeReference<BusquedaTMDB>() {
					});

			log.debug("BusquedaIMDB:" + responseEntity);

			return responseEntity.getBody();
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_BUSQUEDA_TMDB, e);
		}

	}

	@Override
	public PeliculaTMDBDetalle obtenerPelicula(Float id) throws ServicioException {
		log.debug("obtenerPelicula");

		RestTemplate restTemplate = new RestTemplate();

		try {

//		https://api.themoviedb.org/3/movie/343611?api_key=70d5ffa4970bf8d9ade91fa16388f095
			String url = baseUrl + "movie/" + id + "?api_key=" + token;

			PeliculaTMDBDetalle pelicula = restTemplate.getForObject(url, PeliculaTMDBDetalle.class);

			log.debug("pelicula:" + pelicula);

			return pelicula;
		} catch (Exception e) {
			log.error("Exception", e);
			throw new ServicioException(CodeError.ERROR_BUSQUEDA_TMDB, e);
		}
	}

//		pelicula = results.stream()
//			    .filter(pelicula -> pelicula.getId() == 47)
//			    .findFirst()
//			    .orElse(null);

}
