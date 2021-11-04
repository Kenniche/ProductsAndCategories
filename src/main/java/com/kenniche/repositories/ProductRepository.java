package com.kenniche.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kenniche.models.Product;


@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
ArrayList<Product> findAll();
	
	Optional<Product> findById(Long id);
	
	Product save(Product product);
	
	void deleteById(Long id);
	
}
