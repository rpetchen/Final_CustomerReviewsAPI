package com.udacity.course3.reviews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.udacity.course3.reviews.repository.ReviewMongoRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = ReviewMongoRepository.class)
public class ReviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewsApplication.class, args);
	}

}