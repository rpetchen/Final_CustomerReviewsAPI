package com.udacity.course3.reviews.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {

	@Query("select c from Comment c where c.review.review_id =:id")
	List<Comment> findCommentsByReviewId(Integer id);
	
}
