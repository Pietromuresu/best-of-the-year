package org.java.controller;

import java.util.ArrayList;

import org.java.classes.Movie;
import org.java.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(Model model) {
		
		String name = "Pietro Muresu";
		
		model.addAttribute("name", name);
		
		return "index";
	}
	
	private ArrayList<Movie> getBestMovies(){
		
		String[] names = {
		                  "Titanic", 
		                  "Il grande gatsby", 
		                  "Pulp Fiction", 
		                  "Joker",
		                  "Batman",
		                  "Il buco",
		                  "the next three days",
		   				 };
		
		
		ArrayList<Movie> bestMovies = new ArrayList<>();
		
		for(int i = 0; i < names.length; i++) {
			
			Movie movie = new Movie(i, names[i]);
			
			bestMovies.add(movie);
			
		}
		
		return bestMovies;
	}
	
		
	private ArrayList<Song> getBestSongs(){
			
		String[] names = {
		                  "Hallelujah", 
		                  "Sprinter", 
		                  "Yellow", 
		                  "Paint the town red",
		                  "Smells Like Teen Spirit",
		                  "Dreams",
		                  "Let her go",
		   				 };
		
		
		ArrayList<Song> bestSongs = new ArrayList<>();
		
		for(int i = 0; i < names.length; i++) {
			
			Song song = new Song(i, names[i]);
			
			bestSongs.add(song);
			
		}
			
		return bestSongs;
	}

}
