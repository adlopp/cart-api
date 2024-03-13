package com.adrian.backend.cartapp.backendcartapp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.adrian.backend.cartapp.backendcartapp.models.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
