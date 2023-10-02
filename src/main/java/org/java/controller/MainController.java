package org.java.controller;

import java.util.ArrayList;

import org.java.classes.Movie;
import org.java.classes.Song;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(Model model) {
		
		String name = "Pietro Muresu";
		
		model.addAttribute("name", name);
		
		return "index";
	}
	
	
	// See all Movies and Songs
	@GetMapping("/songs")
	public String songs(Model model) {
		ArrayList<Song> songs = getBestSongs();
		StringBuilder songsString = new StringBuilder();
		
		for(Song song : songs) {
			songsString.append(song + (song.equals(songs.get(songs.size() - 1)) ? " " : ",  "));
		}
		
		model.addAttribute("songs", songsString);
		
		return "songs";
		
	}
	
	@GetMapping("/movies")
	public String movies(Model model) {
		ArrayList<Movie> movies = getBestMovies();
		StringBuilder moviesString = new StringBuilder();
		
		for(Movie movie: movies) {
			moviesString.append(movie + (movie.equals(movies.get(movies.size() - 1)) ? " " : ",  "));
		}
		
		model.addAttribute("movies", moviesString);
		
		return "movies";
		
	}
	
	// --------------------------------------
	
	// Get details of a media
	
	@GetMapping("/movies/{id}")
	public String getMoviebById(@PathVariable int id , Model model) {
		ArrayList<Movie> movies = getBestMovies();
		
		String movie = movies.get(id-1).getTitle();
		model.addAttribute("result", movie);
		
		return "mediaDetail";
		
		
	}
	
	@GetMapping("/songs/{id}")
	public String getSongbById(@PathVariable int id , Model model) {
		ArrayList<Song> songs = getBestSongs();
		
		String song = songs.get(id-1).getTitle();
		model.addAttribute("result", song);
		
		return "mediaDetail";
		
		
	}
	
	// --------------------------------------
	
	// Get all Movies and Songs
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
			
			Movie movie = new Movie(i+1, names[i]);
			
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
			
			Song song = new Song(i+1, names[i]);
			
			bestSongs.add(song);
			
		}
			
		return bestSongs;
	}

}
