package com.kenniche.repositories;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kenniche.models.Category;

//import com.kenniche.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

	ArrayList<Category> findAll();
	
	Optional<Category> findById(Long id);
	
	Category save(Category category);
	
	void deleteById(Long id);
}
