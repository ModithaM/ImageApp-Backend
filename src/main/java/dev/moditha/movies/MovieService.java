package dev.moditha.movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
	@Autowired
    private MovieRepository repository;
	
	//function for retrive all movies
	public List<Movie> allMovies() {
		return repository.findAll();
	}
	
	//function for retrive movie by id
	public Optional<Movie> getOneMovie(ObjectId id) { //return type Optional<Movie> because sometimes function may returns null
		return repository.findById(id); //findById is a prdifined method
	}
	
	//function for retrive movie by imdb id  
	//example for method overloading
	public Optional<Movie> getOneMovie(String imdbId){
		return repository.findMovieByImdbId(imdbId);
	}
}
