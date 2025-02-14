package com.example.mapstruct.springmapstruct.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mapstruct.springmapstruct.dto.ProductDto;
import com.example.mapstruct.springmapstruct.entity.Product;
import com.example.mapstruct.springmapstruct.mapper.ProductMapper;
import com.example.mapstruct.springmapstruct.repository.ProductRepository;

@RestController
public class ProductController
{
	private final ProductMapper productMapper;
	private final ProductRepository productRepository;

	public ProductController(ProductMapper productMapper, ProductRepository productRepository)
	{
		this.productMapper = productMapper;
		this.productRepository = productRepository;
	}

	@PostMapping("/products")
	public ResponseEntity<Product> create(@RequestBody ProductDto productDto)
	{
		return new ResponseEntity<>(productRepository.save(
				productMapper.productDtoToProduct(productDto)), HttpStatus.CREATED);
	}

	@GetMapping("/products")
	public ResponseEntity<List<ProductDto>> findAll()
	{
		return new ResponseEntity<>(productMapper.toDtos(
				productRepository.findAll()), HttpStatus.OK);
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<ProductDto> getById(@PathVariable int id)
	{
		return new ResponseEntity<>(productMapper.toDto(
				productRepository.findById(id).get()), HttpStatus.OK);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable int id)
	{
		ProductDto productDto = productMapper.toDto(productRepository.findById(id).get());
		productRepository.deleteById(productDto.getId());
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
