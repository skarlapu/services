package com.learner.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learner.dto.InventoryReponse;
import com.learner.dto.InventoryRequest;
import com.learner.model.Inventory;
import com.learner.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class InventoryService {
	private final InventoryRepository inventoryRepository;

	@Transactional
	public List<InventoryReponse> isInStock(List<String> skuCode) {
		log.info("Begin isInStock:"+skuCode);
		return inventoryRepository.findBySkuCodeIn(skuCode)
				.stream()
				.peek(element -> 
								log.info("skuCode :" + element.getSkuCode() + " is available ?" + element.getQuantity()))
				.map(inventory -> 
								InventoryReponse.builder().skuCode(inventory.getSkuCode())
								.isInStock(inventory.getQuantity() > 0).build()
				)
				.peek(inventory->
								log.info("Product:"+inventory.getSkuCode()+" is in stock:"+inventory.getIsInStock())
				)
				.toList();
	}

	@Transactional
	public void addProductToInventory(InventoryRequest inventoryRequest) {
		inventoryRepository.save(mpToInventory(inventoryRequest));
	}

	private Inventory mpToInventory(InventoryRequest inventoryRequest) {
		return Inventory.builder().skuCode(inventoryRequest.getSkuCode()).quantity(inventoryRequest.getQuantity())
				.build();
	}
}
