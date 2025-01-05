package dev.moditha.movies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//controller class. it will handle the incoming requests

@RestController
@RequestMapping("/api/v1/movies") //endpoint
public class MovieController {
	
	@Autowired
	private MovieService movieservice;
	
	@GetMapping
	public ResponseEntity<List<Movie>> getallMovies() {
		return new ResponseEntity<List<Movie>>(movieservice.allMovies(),HttpStatus.OK);
	}
}
