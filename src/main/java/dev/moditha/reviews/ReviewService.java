package dev.moditha.reviews;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import dev.moditha.movies.Movie;

@Service
public class ReviewService {
	@Autowired
	private ReviewRepository reviewrepository;
	
	@Autowired
	private MongoTemplate mongotemplate;
	
	//function to create a review
	public Review createReview(String reviewBody ,String imdbId) {
		Review review = reviewrepository.insert(new Review(reviewBody));
		
		//pushing the review id to the movie document reviewIds array
		mongotemplate.update(Movie.class)
			.matching(Criteria.where("imdbId").is(imdbId))
			.apply(new Update().push("reviewIds").value(review))
			.first();
		
		return review;
	}
	
	//function to delete a review
	public Boolean deleteReview(ObjectId id) {
		//check review exist
		Optional<Review> review = reviewrepository.findById(id);
		if(review.isPresent()) {
			//delete the review
			reviewrepository.deleteById(id);
			
			//delete reviewId from Moview Collection Array
			mongotemplate.updateMulti(
					Query.query(Criteria.where("reviewIds").is(id)),
	                new Update().pull("reviewIds", id),
	                Movie.class
	        );
			
			return true;
			
		}
		else {
			return false;
		}
		
	}
}
