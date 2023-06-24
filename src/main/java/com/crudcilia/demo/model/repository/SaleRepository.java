package com.crudcilia.demo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudcilia.demo.model.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
