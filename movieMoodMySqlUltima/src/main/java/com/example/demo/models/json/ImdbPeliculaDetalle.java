package com.example.demo.models.json;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class ImdbPeliculaDetalle implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String title;
	private String year;
	private String image;
	private ArrayList<ImdbObjetoRepetido> directorList;
	private String genres;
	private String plotLocal;

	public ImdbPeliculaDetalle() {
	}
	
	public String getDirectoresName() {
		StringBuilder sb = new StringBuilder();
		for (ImdbObjetoRepetido director : directorList) {
		    sb.append(director.getName()).append(", ");
		}

		return sb.toString().replaceAll(", $", ""); 
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ArrayList<ImdbObjetoRepetido> getDirectorList() {
		return directorList;
	}

	public void setDirectorList(ArrayList<ImdbObjetoRepetido> directorList) {
		this.directorList = directorList;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

	public String getPlotLocal() {
		return plotLocal;
	}

	public void setPlotLocal(String plotLocal) {
		this.plotLocal = plotLocal;
	}

	@Override
	public String toString() {
		return "ImdbPeliculaDetalle [id=" + id + ", title=" + title + ", year=" + year + ", image=" + image
				+ ", directorList=" + directorList + ", genres=" + genres + ", plotLocal=" + plotLocal + "]";
	}
	
	

}
