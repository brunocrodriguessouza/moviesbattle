package com.letscode.moviesbattle.services;

import com.letscode.moviesbattle.models.Movie;
import com.letscode.moviesbattle.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(UUID movieId) {
        return movieRepository.findById(movieId);
    }

    public void delete(Movie movie) {
        movieRepository.delete(movie);
    }

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public boolean existsByTitle(String title) {
        return movieRepository.existsByTitle(title);
    }
}
