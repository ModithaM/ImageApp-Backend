package dev.moditha.reviews;

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
	private String id;
	private String body;
	
	//constructor for body
	public Review(String body) {
		super();
		this.body = body;
	}
	
	//getters and setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
}
