package dev.moditha.reviews;

import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewservice;
	
	//review submission endpoint
	@PostMapping
	public ResponseEntity<Review> createReview(@RequestBody Map<String,String> payload){
		return new ResponseEntity<Review>(reviewservice.createReview(payload.get("reviewBody"),payload.get("imdbId")),HttpStatus.CREATED);
	}
	
	//delete review by object id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteReview(@PathVariable ObjectId id) {
		Boolean success = reviewservice.deleteReview(id);
		if(success) {
			return new ResponseEntity<String>("Deleted",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Error",HttpStatus.NOT_FOUND);
		}
	}

}
