package com.udacity.course3.reviews;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ReviewRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Test
	public void testReviewByReviewComment() {
		Product product = getProduct();

		entityManager.persist(product);

		Review review = getReview(product);

		entityManager.persist(review);

		Product actualProduct = productRepository.findProductByName(product.getProductDescription());

		List<Review> actualReviews = reviewRepository.findReviewsByProductId(actualProduct.getProduct_id());

		Review actualReview = actualReviews.get(0);

		assertEquals(review.getReviewComment(), actualReview.getReviewComment());
	}

	private Product getProduct() {
		Product product = new Product();
		product.setProductDescription("Beer");
		return product;
	}

	private Review getReview(Product product) {
		Review review = new Review();
		review.setReviewComment("Great Product!!");
		review.setProduct(product);
		return review;
	}

}
