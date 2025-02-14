package com.example.mapstruct.springmapstruct.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mapstruct.springmapstruct.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>
{
}
