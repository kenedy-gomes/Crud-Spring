package com.crudcilia.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import com.crudcilia.demo.model.Product;
import com.crudcilia.demo.model.services.ProductService;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	
    private static final String UPLOAD_DIR = "caminho/para/salvar/o/arquivo/";


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
	 
	 
	 @PostMapping("/upload")
	 public ResponseEntity<String> handleFileUpload(@RequestPart("file") MultipartFile file) {
	        if (file.isEmpty()) {
	            return ResponseEntity.badRequest().body("O arquivo está vazio.");
	        }

	        try {
	            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	            Path uploadPath = Path.of(UPLOAD_DIR).toAbsolutePath().normalize();
	            Path targetLocation = uploadPath.resolve(fileName);

	            
	            if (!Files.exists(uploadPath)) {
	                Files.createDirectories(uploadPath);
	            }

	             
	            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

	            return ResponseEntity.ok("Arquivo '" + fileName + "' foi enviado com sucesso.");
	        } catch (IOException e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Falha ao realizar o upload do arquivo: " + e.getMessage());
	        }
	    }
	 
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
		 productService.deleteById(id);
	     return ResponseEntity.noContent().build();
	 }
	 
	 @PutMapping("/{id}")
	  public ResponseEntity<Product> editProduct(@PathVariable("id") Long productId, @RequestBody Product updatedProduct) {
	    Product editedProduct = productService.editProduct(productId, updatedProduct);
	    return new ResponseEntity<>(editedProduct, HttpStatus.OK);
	  }
	 
	 
	 
}
