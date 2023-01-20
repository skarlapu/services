package com.learner.model;

import java.math.BigDecimal;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "product")
@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	@Id
	@GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", updatable = false, nullable = false, unique = true)
	@NotBlank
	private String id;
	@Column(name = "product_name", updatable = true, insertable = true, nullable = false)
	@NotBlank(message="Product name should not be empty")
	private String name;
	@Column(name = "description", updatable = true, insertable = true, nullable = false)
	@NotBlank(message="Product description should not be empty")
	private String description;
	@Column(name = "price", updatable = true, insertable = true, nullable = false)
	@Min(value = 1L)
	private BigDecimal price;
}
