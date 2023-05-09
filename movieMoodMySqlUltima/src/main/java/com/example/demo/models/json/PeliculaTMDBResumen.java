package com.example.demo.models.json;

import java.io.Serializable;
import java.util.ArrayList;

public class PeliculaTMDBResumen implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private boolean adult;
	 private String backdrop_path;
	 ArrayList <Integer> genre_ids = new ArrayList <Integer> ();
	 private float id;
	 private String original_language;
	 private String original_title;
	 private String overview;
	 private float popularity;
	 private String poster_path;
	 private String release_date;
	 private String title;
	 private boolean video;
	 private float vote_average;
	 private float vote_count;

	 
	public PeliculaTMDBResumen() {
		super();
		
	}
	public boolean isAdult() {
		return adult;
	}
	public void setAdult(boolean adult) {
		this.adult = adult;
	}
	public String getBackdrop_path() {
		return backdrop_path;
	}
	public void setBackdrop_path(String backdrop_path) {
		this.backdrop_path = backdrop_path;
	}
	public ArrayList<Integer> getGenre_ids() {
		return genre_ids;
	}
	public void setGenre_ids(ArrayList<Integer> genre_ids) {
		this.genre_ids = genre_ids;
	}
	public float getId() {
		return id;
	}
	public void setId(float id) {
		this.id = id;
	}
	public String getOriginal_language() {
		return original_language;
	}
	public void setOriginal_language(String original_language) {
		this.original_language = original_language;
	}
	public String getOriginal_title() {
		return original_title;
	}
	public void setOriginal_title(String original_title) {
		this.original_title = original_title;
	}
	public String getOverview() {
		return overview;
	}
	public void setOverview(String overview) {
		this.overview = overview;
	}
	public float getPopularity() {
		return popularity;
	}
	public void setPopularity(float popularity) {
		this.popularity = popularity;
	}
	public String getPoster_path() {
		return poster_path;
	}
	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isVideo() {
		return video;
	}
	public void setVideo(boolean video) {
		this.video = video;
	}
	public float getVote_average() {
		return vote_average;
	}
	public void setVote_average(float vote_average) {
		this.vote_average = vote_average;
	}
	public float getVote_count() {
		return vote_count;
	}
	public void setVote_count(float vote_count) {
		this.vote_count = vote_count;
	}
	 
	 

}
