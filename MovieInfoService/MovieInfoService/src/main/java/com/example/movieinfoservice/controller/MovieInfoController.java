package com.example.movieinfoservice.controller;

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

import com.example.movieinfoservice.entity.MovieInfo;
import com.example.movieinfoservice.service.MovieInfoService;

@RestController
public class MovieInfoController {
	@Autowired
	private MovieInfoService movieInfoService;

	@PostMapping("/saveMovieInfo")
	public ResponseEntity<MovieInfo> saveMovieInfo(@RequestBody MovieInfo movieInfo) {
		return ResponseEntity.ok(movieInfoService.saveMovieInfo(movieInfo));
	}

	@GetMapping("/getMovieInfoByUsingMovieInfoId/{movieInfoId}")
	public ResponseEntity<List<MovieInfo>> getMovieInfoByUsingMovieInfoId(
			@PathVariable("movieInfoId") int movieInfoId) {
		return ResponseEntity.ok(movieInfoService.getMovieInfoByUsingMovieId(movieInfoId));
	}

	@GetMapping("/getMovieInfoByUsingMovieId/{movieId}")
	public List<MovieInfo> getMovieInfoByUsingMovieId(@PathVariable("movieId") int movieId) {
		return movieInfoService.getMovieInfoByUsingMovieId(movieId);
	}

	@GetMapping("/getAllMovieInfo")
	public ResponseEntity<List<MovieInfo>> getAllMovieInfo() {
		return ResponseEntity.ok(movieInfoService.getAllMovieInfo());
	}

	@PutMapping("/updateMovieByMovieInfoId/{movieInfoId}")
	public ResponseEntity<MovieInfo> updateMovieByMovieInfoId(@RequestBody MovieInfo movieInfo,
			@PathVariable("movieInfoId") int movieInfoId) {
		return ResponseEntity.ok(movieInfoService.updateMovieByMovieInfoId(movieInfo, movieInfoId));
	}

	@DeleteMapping("/deleteMobieByMovieInfoId/{movieInfoId}")
	public ResponseEntity<MovieInfo> deleteMobieByMovieInfoId(@PathVariable("movieInfoId") int MovieInfoId) {
		return ResponseEntity.ok(movieInfoService.deleteMovieByMovieInfoId(MovieInfoId));
	}
}