package com.example.demo.models;

import java.io.Serializable;
import java.util.ArrayList;

public class BusquedaIMDB implements Serializable {

	private static final long serialVersionUID = 1L;

	private float page;
	ArrayList<PeliculaIMDBResumen> results = new ArrayList<PeliculaIMDBResumen>();
	private float total_pages;
	private float total_results;

	public BusquedaIMDB() {
		super();
	}

	public float getPage() {
		return page;
	}

	public void setPage(float page) {
		this.page = page;
	}

	public ArrayList<PeliculaIMDBResumen> getResults() {
		return results;
	}

	public void setResults(ArrayList<PeliculaIMDBResumen> results) {
		this.results = results;
	}

	public float getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(float total_pages) {
		this.total_pages = total_pages;
	}

	public float getTotal_results() {
		return total_results;
	}

	public void setTotal_results(float total_results) {
		this.total_results = total_results;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
