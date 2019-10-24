package com.udacity.course3.reviews.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udacity.course3.reviews.ReviewService;
import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.entity.ReviewDocument;
import com.udacity.course3.reviews.exceptions.ReviewNotFoundException;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ReviewMongoRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;

/**
 * Spring REST controller for working with comment entity.
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

	@Autowired
	ReviewRepository reviewRepository;

	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	ReviewMongoRepository reviewMongoRepository;
	
	@Autowired
	ReviewService reviewService;

	@RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.POST)
	public ResponseEntity<?> createCommentForReview(@PathVariable("reviewId") Integer reviewId,
			@Valid @RequestBody Comment comment) {
		Optional<Review> optionalReview = reviewRepository.findById(reviewId);
		Review review = optionalReview.orElseThrow(ReviewNotFoundException::new);
		comment.setReview(review);
		Comment createdComment = commentRepository.save(comment);
		ReviewDocument  reviewDocument = reviewService.addCommentToReviewDocument(review, createdComment);
		reviewMongoRepository.save(reviewDocument);
		return new ResponseEntity<Comment>(createdComment, HttpStatus.CREATED);
	}

	/**
     * List comments for a review.
     *
     * 2. Check for existence of review.
     * 3. If review not found, return NOT_FOUND.
     * 4. If found, return list of comments.
     *
     * @param reviewId The id of the review.
     */
    @RequestMapping(value = "/reviews/{reviewId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listCommentsForReview(@PathVariable("reviewId") Integer reviewId) {
    	List<Comment> comments = commentRepository.findCommentsByReviewId(reviewId);
    	return new ResponseEntity<List<?>>(comments, HttpStatus.CREATED);
    }
}