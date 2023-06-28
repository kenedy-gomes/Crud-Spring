package com.crudcilia.demo.model.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.crudcilia.demo.model.Product;
import com.crudcilia.demo.model.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Product> findall() {
		return productRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	public Product findById(Long id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado", obj));
	} 
	
	@CrossOrigin(origins = "http://localhost:4200")
	 public Product insert(Product product) {
        return productRepository.save(product);
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	 public void deleteById(Long id) {
		  productRepository.deleteById(id);
	    }
	
	public Product editProduct(Long productId, Product updatedProduct) {
	    Product existingProduct = productRepository.findById(productId)
	        .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + productId));

	    existingProduct.setName(updatedProduct.getName());
	    existingProduct.setDescription(updatedProduct.getDescription());
	    existingProduct.setPrice(updatedProduct.getPrice());

	    return productRepository.save(existingProduct);
	  }

}
