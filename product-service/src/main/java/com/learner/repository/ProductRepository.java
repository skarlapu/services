package com.learner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learner.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

}
