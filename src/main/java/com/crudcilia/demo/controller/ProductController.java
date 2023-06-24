package com.crudcilia.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.crudcilia.demo.model.Product;
import com.crudcilia.demo.model.services.ProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = productService.findall();
		return ResponseEntity.ok().body(list);
	} 
	
	@GetMapping("/{id}")
 	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = productService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	 @PostMapping
	    public ResponseEntity<Product> createClient(@RequestBody Product product) {
		 Product createdClient = productService.insert(product);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
		 productService.deleteById(id);
	     return ResponseEntity.noContent().build();
	 }
}
