package com.learner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learner.dto.ProductRequest;
import com.learner.dto.ProductResponse;
import com.learner.model.Product;
import com.learner.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public void save(ProductRequest request) {
		productRepository.save(Product.builder().name(request.getName()).description(request.getDescription())
				.price(request.getPrice()).build());
	}

	public List<ProductResponse> listAllProducts() {
		return productRepository.findAll().stream().map(element -> mapToProductResponse(element)).toList();
	}

	private ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder().name(product.getName()).description(product.getDescription())
				.price(product.getPrice()).build();
	}

}
