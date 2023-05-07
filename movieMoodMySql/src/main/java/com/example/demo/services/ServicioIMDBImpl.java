package com.example.demo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.models.BusquedaIMDB;
import com.example.demo.services.interfaces.ServicioIMDB;

@Service
public class ServicioIMDBImpl implements ServicioIMDB {

	@Value("${imdb.api.baseUrl}")
	String baseUrl;
	@Value("${imdb.api.token}")
	String token;

	Logger log = LoggerFactory.getLogger(ServicioGeneroImpl.class);

	@Override
	public BusquedaIMDB busquedaPeliculas(String query) {
		log.debug("busquedaPeliculas");

		RestTemplate restTemplate = new RestTemplate();
		String url = baseUrl + "search/movie?include_adult=false&language=en-US&page=1&query=" + query + "&api_key="
				+ token;
		ResponseEntity<BusquedaIMDB> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<BusquedaIMDB>() {
				});
		return responseEntity.getBody();

	}

	@Override
	public void obtenerPelicula(Integer id) {
		// TODO Auto-generated method stub

	}

}
