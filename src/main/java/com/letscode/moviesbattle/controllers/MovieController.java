package com.letscode.moviesbattle.controllers;

import com.letscode.moviesbattle.models.Movie;
import com.letscode.moviesbattle.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.findAll());
    }

    @GetMapping("/{movieId}")
    public ResponseEntity<Object> getOneMovie(@PathVariable(value = "movieId") UUID movieId) {
        Optional<Movie> movieOptional = movieService.findById(movieId);
        if (!movieOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(movieOptional.get());
        }
    }

    @DeleteMapping("/{movieId}")
    public ResponseEntity<Object> deleteMovie(@PathVariable(value = "userId") UUID movieId) {
        Optional<Movie> movieOptional = movieService.findById(movieId);
        if (!movieOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        } else {
            movieService.delete(movieOptional.get());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User deleted with success");
        }
    }

    @PostMapping()
    public ResponseEntity<Object> createMovie(@RequestBody Movie movie){
        if(movieService.existsByTitle(movie.getTitle())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Error: Movie is Already exists!");
        }

        movieService.save(movie);
        return ResponseEntity.status(HttpStatus.CREATED).body(movie);
    }

    @PutMapping("/{movieId}")
    public ResponseEntity<Object> updateMovie(@PathVariable(value = "movieId") UUID userId, @RequestBody Movie movie) {
        Optional<Movie> userModelOptional = movieService.findById(userId);
        if (!userModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        } else {
            movieService.save(movie);
            return ResponseEntity.status(HttpStatus.OK).body(movie);
        }
    }

}
