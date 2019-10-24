package com.udacity.course3.reviews.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class ReviewDocument {
	
	@Id
	private int _id;
	
	
	private String reviewComment;


	private Integer productId;
	
	
	private List<CommentDocument> comments;
	

	public int getReview_id() {
		return _id;
	}

	public void setReview_id(int review_id) {
		_id = review_id;
	}

	public String getReviewComment() {
		return reviewComment;
	}

	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}

	public Integer getProductID() {
		return productId;
	}

	public void setProductID(Integer productId) {
		this.productId = productId;
	}

	public List<CommentDocument> getComments() {
		return comments;
	}

	public void setComments(List<CommentDocument> comments) {
		this.comments = comments;
	}
	
	
}
