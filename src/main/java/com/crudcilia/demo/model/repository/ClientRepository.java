package com.crudcilia.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudcilia.demo.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	Client findByEmail(String email);

 

 

 

	 
}
