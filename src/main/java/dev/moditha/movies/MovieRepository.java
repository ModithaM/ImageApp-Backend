package dev.moditha.movies;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//repository class. it will handle the database operations

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
	
	//custom method for find movie by imdb id
	Optional<Movie> findMovieByImdbId(String imdbId);
	
}
