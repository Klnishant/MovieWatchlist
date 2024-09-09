package com.example.watchlist.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.watchlist.models.Movie;
import com.example.watchlist.services.DatabaseService;

import jakarta.validation.Valid;

@RestController
public class MovieController {
	
	@Autowired
	DatabaseService databaseService;
	
	@GetMapping("/watchlistItemForm")
	public ModelAndView showWatchlistForm(@RequestParam(required = false) Integer id) {
		
		String viewName = "watchListItemForm";
		
		Map<String,Object> model = new HashMap<>();
		
		model.put("watchlistItem", new Movie());
		
		if(id == null) {
			model.put("watchlistItem", new Movie());
		} else {
			model.put("watchlistItem", databaseService.getMovieById(id));
		}
		
		return new ModelAndView(viewName,model);
	}
	
	@PostMapping("/watchlistItemForm")
	public ModelAndView submitWatchListForm(@Valid @ModelAttribute("watchlistItem") Movie movie,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return new ModelAndView("watchlistItemForm");
		}
		
		Integer id = movie.getId();
		
		if(id==null) {
			databaseService.create(movie);
		} else {
			databaseService.updateMovie(movie, id);
		}
		
		RedirectView rd = new RedirectView();
		rd.setUrl("/watchlist");
		
		return new ModelAndView(rd);
	}
	
	@GetMapping("/watchlist")
	public ModelAndView getWatchList() {
		String viewName = "watchlist";
		Map<String,Object> model = new HashMap<>();
		List<Movie> movielist = databaseService.getAllMovies();
		model.put("watchlistrows", movielist);
		model.put("noofmovies", movielist.size());
		
		return new ModelAndView(viewName,model);
	}
}
