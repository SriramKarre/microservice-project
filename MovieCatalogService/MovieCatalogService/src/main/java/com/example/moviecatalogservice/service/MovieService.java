package com.example.moviecatalogservice.service;

import java.util.List;

import com.example.moviecatalogservice.entity.Movie;

public interface MovieService {
	public Movie saveMovie(Movie movie);

	public Movie getMovieByUsingMovieId(int movieId);

	public List<Movie> getAllMovies();
	
	public Movie updateMovieByMovieId(Movie movie,int movieId);
	
	public Movie deleteMovieByMovieId(int movieId);

}