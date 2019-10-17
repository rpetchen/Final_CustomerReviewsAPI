package com.udacity.course3.reviews;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private CommentRepository commentRepository;

	@Test
	public void testCommentByCommentText (){
		Product product = getProduct();
		Review review = getReview(product);
		Comment comment = getComment(review);
		
		entityManager.persist(product);
		entityManager.persist(review);
		entityManager.persist(comment);

		Product actualProduct = productRepository.findProductByName(product.getProductDescription());

		List<Review> actualReviews = reviewRepository.findReviewsByProductId(actualProduct.getProduct_id());

		Review actualReview = actualReviews.get(0);
		
		List<Comment> actualComments = commentRepository.findCommentsByReviewId(actualReview.getReview_id());
		
		Comment actualComment = actualComments.get(0);

		assertEquals(comment.getComment(), actualComment.getComment());
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

	private Comment getComment(Review review) {
		Comment comment = new Comment();
		comment.setComment("Totally agree! 4 ****");
		comment.setReview(review);
		return comment;
	}
}
