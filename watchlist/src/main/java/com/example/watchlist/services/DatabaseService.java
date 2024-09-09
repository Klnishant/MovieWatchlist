package com.example.watchlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.watchlist.models.Movie;
import com.example.watchlist.repositories.MovieRepo;

@Service
public class DatabaseService {
	
	@Autowired
	MovieRepo movieRepo;
	
	@Autowired
	RatingService ratingService;
	
	public void create(Movie movie) {
		String rating = ratingService.getMovieRating(movie.getTitle());
		
		if(rating !=null) {
			movie.setRating(Float.parseFloat(rating));
		}
		movieRepo.save(movie);
	}
	
	public List<Movie> getAllMovies(){
		
		return movieRepo.findAll();
	}
	
	public Movie getMovieById(Integer id) {
		return movieRepo.findById(id).get();
	}
	
	public void updateMovie(Movie movie,Integer id) {
		Movie movieToBeUpdated = getMovieById(id);
		
		movieToBeUpdated.setTitle(movie.getTitle());
		movieToBeUpdated.setRating(movie.getRating());
		movieToBeUpdated.setPriority(movie.getPriority());
		movieToBeUpdated.setComment(movie.getComment());
		
		movieRepo.save(movieToBeUpdated);
	}
}
