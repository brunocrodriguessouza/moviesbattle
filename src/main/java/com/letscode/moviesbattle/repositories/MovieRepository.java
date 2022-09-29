package com.letscode.moviesbattle.repositories;

import com.letscode.moviesbattle.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {
    boolean existsByTitle(String title);
}
