package com.learner.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learner.dto.OrderRequest;
import com.learner.service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
	private final OrderService orderService;
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void placeOrder(@RequestBody OrderRequest request) {
		
		orderService.saveOrder(request);
	}
}
