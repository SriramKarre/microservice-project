package com.example.movieinfoservice.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.movieinfoservice.entity.MovieInfo;
import com.example.movieinfoservice.repository.MovieInfoRepository;
import com.example.movieinfoservice.service.MovieInfoService;

@Service
public class MovieInfoServiceImpl implements MovieInfoService {

    @Autowired
    private MovieInfoRepository movieInfoRepository;

    @Override
    @CachePut(value = "movieInfo", key = "#movieInfo.movieInfoId")
    public MovieInfo saveMovieInfo(MovieInfo movieInfo) {
        return movieInfoRepository.save(movieInfo);
    }

    @Override
    @Cacheable(value = "movieInfoListByInfoId", key = "#movieInfoId")
    public List<MovieInfo> getMovieInfoByUsingMovieInfoId(int movieInfoId) {
        return movieInfoRepository.findByMovieInfoId(movieInfoId);
    }

    @Override
    @Cacheable(value = "movieInfoListByMovieId", key = "#movieId")
    public List<MovieInfo> getMovieInfoByUsingMovieId(int movieId) {
        return movieInfoRepository.findByMovieId(movieId);
    }

    @Override
    @Cacheable(value = "allMovieInfos")
    public List<MovieInfo> getAllMovieInfo() {
        return movieInfoRepository.findAll();
    }

    @Override
    @CachePut(value = "movieInfo", key = "#movieInfoId")
    public MovieInfo updateMovieByMovieInfoId(MovieInfo movieInfo, int movieInfoId) {
        MovieInfo movieInfo1 = movieInfoRepository.findMovieByMovieInfoId(movieInfoId);

        movieInfo1.setMovieId(movieInfo.getMovieId());
        movieInfo1.setMovieCast(movieInfo.getMovieCast());
        movieInfo1.setMovieDuration(movieInfo.getMovieDuration());
        movieInfo1.setMovieCollections(movieInfo.getMovieCollections());

        return movieInfoRepository.save(movieInfo1);
    }

    @Override
    @CacheEvict(value = "movieInfo", key = "#movieInfoId")
    public MovieInfo deleteMovieByMovieInfoId(int movieInfoId) {
        return movieInfoRepository.deleteMovieInfoByMovieInfoId(movieInfoId);
    }
}
