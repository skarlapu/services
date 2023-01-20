package com.learner.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_line_items")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class OrderLineItem {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "skucode", insertable = true, updatable = true, nullable = false)
	private String skuCode;
	@Column(name = "price", insertable = true, updatable = true, nullable = false)
	private BigDecimal price;
	@Column(name = "quantity", insertable = true, updatable = true, nullable = false)
	private long quantity;
	@Column(name="order_number")
	private String orderNumber;
	

}
