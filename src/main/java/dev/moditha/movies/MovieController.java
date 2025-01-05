package dev.moditha.movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//controller class. it will handle the incoming requests

@RestController
@RequestMapping("/api/v1/movies") //endpoint
public class MovieController {
	
	@Autowired
	private MovieService movieservice;
	
	//response for default get request
	@GetMapping
	public ResponseEntity<List<Movie>> getallMovies() {
		return new ResponseEntity<List<Movie>>(movieservice.allMovies(),HttpStatus.OK);
	}
	
	//response for get request with id
	@GetMapping("/dbid/{id}")
	public ResponseEntity<Optional<Movie>> getoneMovie(@PathVariable ObjectId id){
		return new ResponseEntity<Optional<Movie>>(movieservice.getOneMovie(id),HttpStatus.OK);
	}
	
	//get movie using imdb id
	//example for method overloading
	@GetMapping("/{imdbId}")
	public ResponseEntity<Optional<Movie>> getoneMovie(@PathVariable String imdbId){
		return new ResponseEntity<Optional<Movie>>(movieservice.getOneMovie(imdbId),HttpStatus.OK);
	}
}
