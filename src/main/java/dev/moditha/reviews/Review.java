package dev.moditha.reviews;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection="reviews")
@Data  //its for getters and setters
@AllArgsConstructor //its for Constructor
@NoArgsConstructor
public class Review {
		
	@Id
	private ObjectId id;
	private String body;

}
