package com.learner.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Builder
@Setter
@Getter
@NoArgsConstructor
public class ProductRequest {
	@NotBlank
	@NotNull
	private String name;
	@NotBlank
	@NotNull
	private String description;
	@Min(1)
	@NotNull
	private BigDecimal price;
}
