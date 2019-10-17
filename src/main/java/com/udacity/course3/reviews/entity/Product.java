package com.udacity.course3.reviews.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PRODUCTS")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int product_id;
	
	@Column(name = "product_desc")
	@NotNull
	private String productDescription;
	
	@OneToMany(mappedBy = "product")
	@JsonIgnore
	private List<Review> reviews = new ArrayList<>();

	public int getProduct_id() {
		return product_id;
	}

	

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}



	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public void setReview(Review review) {
		reviews.add(review);
	}


	public List<Review> getReviews() {
		return reviews;
	}



	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

}
