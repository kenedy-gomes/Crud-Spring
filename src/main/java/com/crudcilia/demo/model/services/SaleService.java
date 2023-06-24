package com.crudcilia.demo.model.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.crudcilia.demo.model.Sale;
import com.crudcilia.demo.model.repository.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	SaleRepository saleRepository;


	@CrossOrigin(origins = "http://localhost:4200")
	public List<Sale> findall() {
		return saleRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	public Sale findById(Long id) {
		Optional<Sale> obj = saleRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado", obj));
	} 
	
	@CrossOrigin(origins = "http://localhost:4200")
	 public Sale insert(Sale sale) {
        return saleRepository.save(sale);
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	 public void deleteById(Long id) {
		saleRepository.deleteById(id);
	    }
	
}
