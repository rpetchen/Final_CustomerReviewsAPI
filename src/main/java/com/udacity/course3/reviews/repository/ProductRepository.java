package com.udacity.course3.reviews.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.udacity.course3.reviews.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	@Query ("select p from Product p where p.productDescription = :pName")
	Product findProductByName(String pName);
	
}
