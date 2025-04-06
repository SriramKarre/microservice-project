package com.example.moviecatalogservice.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int movieId;
	private String movieName;
	private String movieDirector;
	private int movieBudject;
	@Transient
	private List<MovieInfo> movieInfoList;
	@Transient
	private List<MovieRating> movieRatingList;

	public List<MovieInfo> getMovieInfoList() {
		return movieInfoList;
	}

	public void setMovieInfoList(List<MovieInfo> movieInfoList) {
		this.movieInfoList = movieInfoList;
	}

	public List<MovieRating> getMovieRatingList() {
		return movieRatingList;
	}

	public void setMovieRatingList(List<MovieRating> movieRatingList) {
		this.movieRatingList = movieRatingList;
	}

	public Movie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Movie(int movieId, String movieName, String movieDirector, int movieBudject) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieBudject = movieBudject;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public int getMovieBudject() {
		return movieBudject;
	}

	public void setMovieBudject(int movieBudject) {
		this.movieBudject = movieBudject;
	}

}