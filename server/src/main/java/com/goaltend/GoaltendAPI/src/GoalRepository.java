// For persistance -- we extend MongoRepo here
package com.goaltend.GoaltendAPI.src;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GoalRepository extends MongoRepository<Goal, String> {
	

}
