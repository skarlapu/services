package com.learner.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learner.dto.ProductRequest;
import com.learner.dto.ProductResponse;
import com.learner.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
	private final ProductService productService;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<ProductResponse> getProducts() {
		return productService.listAllProducts();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addProduct(@RequestBody @Valid ProductRequest request) {
		productService.save(request);
	}
}
