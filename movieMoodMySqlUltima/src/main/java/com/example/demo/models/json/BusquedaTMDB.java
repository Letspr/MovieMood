package com.example.demo.models.json;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BusquedaTMDB implements Serializable {

	private static final long serialVersionUID = 1L;

	private float page;
	ArrayList<PeliculaTMDBResumen> results = new ArrayList<PeliculaTMDBResumen>();
	private float total_pages;
	private float total_results;

	public BusquedaTMDB() {
	}

	public float getPage() {
		return page;
	}

	public void setPage(float page) {
		this.page = page;
	}

	public ArrayList<PeliculaTMDBResumen> getResults() {
		return results;
	}

	public void setResults(ArrayList<PeliculaTMDBResumen> results) {
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

	@Override
	public String toString() {
		return "BusquedaIMDB [page=" + page + ", results=" + results + ", total_pages=" + total_pages
				+ ", total_results=" + total_results + "]";
	}
	
	

}
