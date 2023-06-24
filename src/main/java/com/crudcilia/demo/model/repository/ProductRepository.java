package com.crudcilia.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudcilia.demo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
