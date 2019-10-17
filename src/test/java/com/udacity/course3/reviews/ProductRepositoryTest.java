package com.udacity.course3.reviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.repository.ProductRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ProductRepository productRepository;

	@Test
	public void testFindByProductId() {
		Product product = getProduct();

		entityManager.persist(product);

		Product actual = productRepository.findProductByName(product.getProductDescription());

		assertEquals(product.getProductDescription(), actual.getProductDescription());
	}

	private Product getProduct() {
		Product product = new Product();
		product.setProductDescription("Beer");
		return product;
	}

}
