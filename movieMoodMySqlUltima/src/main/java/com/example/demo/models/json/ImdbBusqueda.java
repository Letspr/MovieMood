package com.example.demo.models.json;

import java.io.Serializable;
import java.util.ArrayList;

public class ImdbBusqueda implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String searchType;
	private String expression;
	ArrayList<ImdbPeliculaResumen> results = new ArrayList<ImdbPeliculaResumen>();
	private String errorMessage;

	public ImdbBusqueda() {
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public ArrayList<ImdbPeliculaResumen> getResults() {
		return results;
	}

	public void setResults(ArrayList<ImdbPeliculaResumen> results) {
		this.results = results;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "ImdbBusqueda [searchType=" + searchType + ", expression=" + expression + ", results=" + results
				+ ", errorMessage=" + errorMessage + "]";
	}

}
