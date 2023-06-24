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
import com.crudcilia.demo.model.Sale;
import com.crudcilia.demo.model.services.SaleService;

@Controller
@RequestMapping(value = "/sale")
public class SaleController {
	
	@Autowired
	SaleService saleService;

	@GetMapping
	public ResponseEntity<List<Sale>> findAll(){
		List<Sale> list = saleService.findall();
		return ResponseEntity.ok().body(list);
	} 
	
	@GetMapping("/{id}")
 	public ResponseEntity<Sale> findById(@PathVariable Long id) {
		Sale obj = saleService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	 @PostMapping
	    public ResponseEntity<Sale> createSale(@RequestBody Sale sale) {
		 Sale createdClient = saleService.insert(sale);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
	    }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteSale(@PathVariable Long id) {
		 saleService.deleteById(id);
	     return ResponseEntity.noContent().build();
	 }
}
