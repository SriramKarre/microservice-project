package com.example.moviecatalogservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviecatalogservice.entity.Movie;
import com.example.moviecatalogservice.service.MovieService;

@RestController
//@RequestMapping("/movies")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@PostMapping("/saveMovie")
	public ResponseEntity<Movie> saveMovie(@RequestBody Movie movie) {
		return ResponseEntity.ok(movieService.saveMovie(movie));
	}

	@GetMapping("/getMovieByUsingMovieId/{movieId}")
	public ResponseEntity<Movie> getMovieByUsingMovieId(@PathVariable("movieId") int movieId) {
		return ResponseEntity.ok(movieService.getMovieByUsingMovieId(movieId));
	}

	@GetMapping("/getAllMovies")
	public ResponseEntity<List<Movie>> getAllMovies() {
		return ResponseEntity.ok(movieService.getAllMovies());
	}

	@PutMapping("/updateMovieByMovieId/{movieId}")
	public ResponseEntity<Movie> updateMovieByMovieId(@RequestBody Movie movie, @PathVariable("movieId") int movieId) {
		return ResponseEntity.ok(movieService.updateMovieByMovieId(movie, movieId));
	}

	@DeleteMapping("/deleteMovieByMovieId/{movieId}")
	public ResponseEntity<Movie> deleteMovieByMovieId(@PathVariable("movieId") int movieId) {
		return ResponseEntity.ok(movieService.deleteMovieByMovieId(movieId));
	}
}