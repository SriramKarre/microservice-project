package com.example.movieratingservice.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieratingservice.entity.MovieRating;
import com.example.movieratingservice.repository.MovieRatingRepository;
import com.example.movieratingservice.service.MovieRatingService;

@Service
public class MovieRatingServiceImpl implements MovieRatingService {
	@Autowired
	private MovieRatingRepository movieRatingRepository;

	@Override
	public MovieRating saveMovieRating(MovieRating movieRating) {
		return movieRatingRepository.save(movieRating);
	}

	@Override
	public List<MovieRating> getMovieRatingByUsingRatingId(int ratingId) {
		return movieRatingRepository.findByRatingId(ratingId);
	}

	@Override
	public List<MovieRating> getMovieRatingByUsingMovieId(int movieId) {
		return movieRatingRepository.findByMovieId(movieId);
	}

	@Override
	public List<MovieRating> getMovieRatingByUsingMovieInfoId(int movieInfoId) {
		return movieRatingRepository.findByMovieInfoId(movieInfoId);
	}

	@Override
	public List<MovieRating> getAllMovieRatings() {
		return movieRatingRepository.findAll();
	}

	@Override
	public MovieRating updateMovieRatingByUsingMovieRatingId(MovieRating movieRating, int ratingId) {
		// TODO Auto-generated method stub
		MovieRating movieRating1 = movieRatingRepository.findMovieByRatingId(ratingId);
		movieRating1.setMovieId(movieRating.getMovieId());
		movieRating1.setMovieInfoId(movieRating.getMovieInfoId());
		movieRating1.setRating(movieRating.getRating());
		movieRating1.setFeedback(movieRating.getFeedback());
		return movieRatingRepository.save(movieRating1);
	}

	@Override
	public MovieRating deleteMovieRatingByUsingMovieRatingId(int ratingId) {
		// TODO Auto-generated method stub
		return movieRatingRepository.deleteMovieByRatingId(ratingId);
	}
}