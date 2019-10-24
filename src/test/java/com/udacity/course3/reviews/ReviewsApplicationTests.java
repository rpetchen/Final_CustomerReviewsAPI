package com.udacity.course3.reviews;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.MongoClient;

@RunWith(SpringRunner.class)
@DataJpaTest
@EnableMongoRepositories 
public class ReviewsApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Bean
	public MongoClient m() throws Exception {
		return new MongoClient("localhost");
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(m(), "databaseName");
	}

}