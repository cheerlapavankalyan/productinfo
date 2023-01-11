package com.pk.product_info.repository;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pk.product_info.entity.Product;


public interface productRepository extends MongoRepository<Product, String>{
	  
  Optional<Product> findByProductName(String name);
  
  
}

