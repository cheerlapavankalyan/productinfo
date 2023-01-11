package com.pk.product_info.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pk.product_info.entity.Product;
import com.pk.product_info.repository.productRepository;


@Service
public class productService {
  
  @Autowired
  public productRepository productRepository;

  //This method returns all the products
  //that are saved in the database
  public List<Product> getAllProducts(){
    return productRepository.findAll();
  }

  public Optional<Product> getByProductId(String productId){
    return productRepository.findById(productId);
  }

  public Optional<Product> getByProductName(String name){
    return productRepository.findByProductName(name);
  }

  public Product addProduct(Product product){
    return productRepository.save(product);
  }

  public String deleteProduct(String productId){
    Optional<Product> productOptional = productRepository.findById(productId);
    if(productOptional.isPresent()){
      productRepository.deleteById(productId);
      return "Product with id"+ productId +
      " is successfully deleted";
    }
    else{
      return "No product with id"+productId+
      "found";
    }
  }

  public String updateProduct(Product product){
    Optional<Product> optionalProduct = productRepository.findById((product.getProductId()));
    if(optionalProduct.isPresent()){
      Product prod = optionalProduct.get();
      prod.setProductPrice(product.getProductPrice());
      prod.setProductQty(product.getProductQty());
      productRepository.save(prod);
      return "Product details updated "
      +prod;
    }
    else{
      return "No such product";
    }
  }
}