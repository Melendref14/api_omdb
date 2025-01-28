package com.example.backend_omdb.repository;

import com.example.backend_omdb.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
}