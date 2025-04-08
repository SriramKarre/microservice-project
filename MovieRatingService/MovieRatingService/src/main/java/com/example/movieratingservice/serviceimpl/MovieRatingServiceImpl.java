package com.example.movieratingservice.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(value = "ratingsById", key = "#ratingId")
    public List<MovieRating> getMovieRatingByUsingRatingId(int ratingId) {
        return movieRatingRepository.findByRatingId(ratingId);
    }

    @Override
    @Cacheable(value = "ratingsByMovieId", key = "#movieId")
    public List<MovieRating> getMovieRatingByUsingMovieId(int movieId) {
        return movieRatingRepository.findByMovieId(movieId);
    }

    @Override
    @Cacheable(value = "ratingsByMovieInfoId", key = "#movieInfoId")
    public List<MovieRating> getMovieRatingByUsingMovieInfoId(int movieInfoId) {
        return movieRatingRepository.findByMovieInfoId(movieInfoId);
    }

    @Override
    @Cacheable(value = "allRatings")
    public List<MovieRating> getAllMovieRatings() {
        return movieRatingRepository.findAll();
    }

    @Override
    @CachePut(value = "ratingsById", key = "#ratingId")
    public MovieRating updateMovieRatingByUsingMovieRatingId(MovieRating movieRating, int ratingId) {
        MovieRating movieRating1 = movieRatingRepository.findMovieByRatingId(ratingId);
        movieRating1.setMovieId(movieRating.getMovieId());
        movieRating1.setMovieInfoId(movieRating.getMovieInfoId());
        movieRating1.setRating(movieRating.getRating());
        movieRating1.setFeedback(movieRating.getFeedback());
        return movieRatingRepository.save(movieRating1);
    }

    @Override
    @CacheEvict(value = "ratingsById", key = "#ratingId")
    public MovieRating deleteMovieRatingByUsingMovieRatingId(int ratingId) {
        return movieRatingRepository.deleteMovieByRatingId(ratingId);
    }
}
