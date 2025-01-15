package dev.moditha.reviews;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

//repository class. it will handle the database operations for review

@Repository
public interface ReviewRepository extends MongoRepository<Review ,ObjectId> {

}
