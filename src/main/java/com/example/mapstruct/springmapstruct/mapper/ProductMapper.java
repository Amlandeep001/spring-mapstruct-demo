package com.example.mapstruct.springmapstruct.mapper;

import java.util.List;
import java.util.UUID;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.mapstruct.springmapstruct.dto.ProductDto;
import com.example.mapstruct.springmapstruct.entity.Product;

@Mapper(componentModel = "spring", imports = UUID.class)
public interface ProductMapper
{
	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

	@Mapping(source = "product.name", target = "desc", defaultValue = "product desc")
	ProductDto toDto(final Product product);

	List<ProductDto> toDtos(final List<Product> products);

	@InheritInverseConfiguration
	Product productDtoToProduct(final ProductDto productDto);
}
