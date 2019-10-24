package com.udacity.course3.reviews.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.udacity.course3.reviews.entity.ReviewDocument;

@Repository
public interface ReviewMongoRepository extends MongoRepository<ReviewDocument, String> {

	List<ReviewDocument> findReviewsByProductId(Integer productId);

	ReviewDocument findReviewBy_id(Integer id);

	@Query("select r from ReviewDocument r where r._id in :ids")
	List<ReviewDocument> findBy_idIn(List<Integer> ids);

}
