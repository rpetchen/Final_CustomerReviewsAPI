package com.udacity.course3.reviews;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.udacity.course3.reviews.entity.ReviewDocument;
import com.udacity.course3.reviews.repository.ReviewMongoRepository;

import junit.framework.Assert;

@DataMongoTest
@RunWith(SpringRunner.class)
public class ReviewMongoRepositoryTest {

	@Autowired
	private ReviewMongoRepository reviewMongoRepository;

	@Before
	public void dataSetup() {

		ReviewDocument reviewDocument1 = getReviewDocument("Great Product", 3, 1);
		ReviewDocument reviewDocument2 = getReviewDocument("Its the best", 3, 2);

		reviewMongoRepository.save(reviewDocument1);
		reviewMongoRepository.save(reviewDocument2);
	}

	@Test
	public void retrieveReviewByReviewID() {
		ReviewDocument reviewDocument = reviewMongoRepository.findReviewBy_id(1);
		assertThat(reviewDocument.getReviewComment(), is("Great Product"));
	}

	@Test
	public void retrieveReviewsByIdIn() {
		List<Integer> reviewIdList = Arrays.asList(1, 2);

		List<ReviewDocument> reviewDocumentList = reviewMongoRepository.findBy_idIn(reviewIdList);

		List<Integer> actualIdList = reviewDocumentList.stream().map(p -> p.getReview_id())
				.collect(Collectors.toList());

		assertEquals(reviewIdList, actualIdList);
	}

	public ReviewDocument getReviewDocument(String reviewText, Integer productId, Integer reviewId) {
		
		ReviewDocument reviewDocument = new ReviewDocument();
		reviewDocument.setReview_id(reviewId);
		reviewDocument.setProductID(productId);
		reviewDocument.setReviewComment(reviewText);

		return reviewDocument;
	}
}
