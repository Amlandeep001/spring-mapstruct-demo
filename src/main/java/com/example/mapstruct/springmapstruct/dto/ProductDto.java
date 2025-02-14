package com.example.mapstruct.springmapstruct.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class ProductDto
{
	int id;
	String desc;
	BigDecimal price;
	String quantity;
}
