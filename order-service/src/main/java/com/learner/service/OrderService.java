package com.learner.service;

import java.util.Arrays;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.learner.dto.InventoryReponse;
import com.learner.dto.Item;
import com.learner.dto.OrderRequest;
import com.learner.exception.ProductIsNotInStock;
import com.learner.model.Order;
import com.learner.model.OrderLineItem;
import com.learner.repository.OrderRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {
	private final OrderRepository order;
	private final WebClient.Builder webClientBuilder;

	@Transactional
	public void saveOrder(OrderRequest request) {
		log.info("Begin saveOrder");
		if (isInStock(request)) {
			log.info("Requested Product/Products are available in the inventory");
			order.save(Order.builder()
					.orderLineItems(request.getItems().stream().map(OrderService::mapToOrder).toList()).build());
		} else {
			log.info("Requested Product/Products is/are not available in the inventory");
			throw new ProductIsNotInStock("Product you requested is out of stock ");
		}
		log.info("End of saveOrder");
	}

	private static OrderLineItem mapToOrder(Item item) {
		return OrderLineItem.builder().price(item.getPrice()).quantity(item.getQuantity()).skuCode(item.getSkuCode())
				.build();
	}

	private boolean isInStock(OrderRequest request) {
		log.info("Begin isInStock");
		InventoryReponse[] inventoryResponses = webClientBuilder.build().get()
				.uri("http://inventory-service/api/inventory", uriBuilder -> uriBuilder
						.queryParam("skuCode", request.getItems().stream().map(t -> t.getSkuCode()).toList()).build())
				.retrieve().bodyToMono(InventoryReponse[].class).block();
		log.info("Inventory response from Inventory service :" + inventoryResponses.length);
		if (inventoryResponses.length==0)
				return false;
		else 
		return Arrays.stream(inventoryResponses)
				.peek(element -> log
						.info("skuCode :" + element.getSkuCode() + " is in the stock ? " + element.getIsInStock()))
				.allMatch(InventoryReponse::getIsInStock);

	}

}
