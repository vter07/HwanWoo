package com.example.moviesearch.repository;

import com.example.moviesearch.dto.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieEntityRepository extends JpaRepository<MovieEntity, Long> {
}
