package com.learner.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learner.service.ProductService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductControllerTest {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private ProductService productService;

	private MockRestServiceServer mockRestServiceServer;
	private ObjectMapper mapper;

	@BeforeEach
	public void init() {
		mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
	}
	
	@Test
	public void givenMockeProductService_shouldReturnProduct() {
		
	}
}
