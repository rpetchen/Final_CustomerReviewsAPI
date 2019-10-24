package com.udacity.course3.reviews;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.CommentDocument;
import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.entity.ReviewDocument;

@Service
public class ReviewService {

	public ReviewDocument ReviewEntityToDocument(Review review) {

		ReviewDocument reviewDocument = new ReviewDocument();

		if (review.getComments() != null) {
			reviewDocument.setComments(CommentEntityToDocument(review.getComments()));
		}

		reviewDocument.setReview_id(review.getReview_id());
		reviewDocument.setProductID(review.getProduct().getProduct_id());
		reviewDocument.setReviewComment(review.getReviewComment());
		return reviewDocument;

	}

	public ReviewDocument addCommentToReviewDocument(Review review, Comment createdComment) {
		review.getComments().add(createdComment);
		ReviewDocument reviewDocument = ReviewEntityToDocument(review);
		return reviewDocument;
	}

	public List<CommentDocument> CommentEntityToDocument(List<Comment> comments) {

		List commentDocumentList = new ArrayList<CommentDocument>();

		for (Comment c : comments) {
			CommentDocument cd = new CommentDocument();
			cd.setComemnt_id(c.getComemnt_id());
			cd.setComment(c.getComment());
			commentDocumentList.add(cd);
		}

		return commentDocumentList;

	}

	public List<Integer> getReviewIDsFromProduct(Product product) {
		List<Integer> reviewIdentifiers = new ArrayList<Integer>();
		if (product != null) {
			reviewIdentifiers = product.getReviews().stream().map(p -> p.getReview_id()).collect(Collectors.toList());
		}

		return reviewIdentifiers;
	}
}
