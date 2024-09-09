package com.example.watchlist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.watchlist.models.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {

}
