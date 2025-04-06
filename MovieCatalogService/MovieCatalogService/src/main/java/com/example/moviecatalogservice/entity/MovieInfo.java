package com.example.moviecatalogservice.entity;

public class MovieInfo {
	private int movieInfoId;
	private int movieId;
	private String movieCast;
	private String movieDuration;
	private int movieCollections;

	public MovieInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieInfo(int movieInfoId, int movieId, String movieCast, String movieDuration, int movieCollections) {
		super();
		this.movieInfoId = movieInfoId;
		this.movieId = movieId;
		this.movieCast = movieCast;
		this.movieDuration = movieDuration;
		this.movieCollections = movieCollections;
	}

	public int getMovieInfoId() {
		return movieInfoId;
	}

	public void setMovieInfoId(int movieInfoId) {
		this.movieInfoId = movieInfoId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieCast() {
		return movieCast;
	}

	public void setMovieCast(String movieCast) {
		this.movieCast = movieCast;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public int getMovieCollections() {
		return movieCollections;
	}

	public void setMovieCollections(int movieCollections) {
		this.movieCollections = movieCollections;
	}

}