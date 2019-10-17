package com.udacity.course3.reviews.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.course3.reviews.entity.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer> {

	@Query("select r from Review r where r.product.product_id =:id")
	List<Review> findReviewsByProductId(Integer id);
}
