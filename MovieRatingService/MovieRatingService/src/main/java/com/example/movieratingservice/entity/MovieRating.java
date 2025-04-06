package com.example.movieratingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MovieRating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ratingId;
	private int movieId;
	private int movieInfoId;
	private int rating;
	private String feedback;

	public MovieRating() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MovieRating(int ratingId, int movieId, int movieInfoId, int rating, String feedback) {
		super();
		this.ratingId = ratingId;
		this.movieId = movieId;
		this.movieInfoId = movieInfoId;
		this.rating = rating;
		this.feedback = feedback;
	}

	public int getRatingId() {
		return ratingId;
	}

	public void setRatingId(int ratingId) {
		this.ratingId = ratingId;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getMovieInfoId() {
		return movieInfoId;
	}

	public void setMovieInfoId(int movieInfoId) {
		this.movieInfoId = movieInfoId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

}