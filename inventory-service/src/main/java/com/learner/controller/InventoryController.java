package com.learner.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learner.dto.InventoryReponse;
import com.learner.dto.InventoryRequest;
import com.learner.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
	private final InventoryService inventoryService;

	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public List<InventoryReponse> isInStock(@RequestParam List<String> skuCode) {
		return inventoryService.isInStock(skuCode);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void addProductToInventory(@RequestBody InventoryRequest inventoryRequest) {
		inventoryService.addProductToInventory(inventoryRequest);
	}

}
