package dev.moditha.movies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
	@Autowired
    private MovieRepository repository;
	
	public List<Movie> allMovies() {
		return repository.findAll();
	}
}
