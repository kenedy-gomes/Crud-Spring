package com.crudcilia.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

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
import com.crudcilia.demo.DTO.ClientDTO;
import com.crudcilia.demo.config.JwtTokenUtil;
import com.crudcilia.demo.model.Client;
import com.crudcilia.demo.model.services.ClientService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Controller
@RequestMapping(value = "/client")
public class ClientControler {
	
	 @Autowired
	 private ClientService clientService;
	
     @Autowired
	 JwtTokenUtil jwt;
 
	
	 @GetMapping
	 public ResponseEntity<List<Client>> findAll(){
		List<Client> list = clientService.findall();
		return ResponseEntity.ok().body(list);
	} 
	
	 @GetMapping("/{id}")
 	 public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {
		Client obj = clientService.findById(id);
		return ResponseEntity.ok().body(new ClientDTO(obj));
	}
	
	 @PostMapping
	 public ResponseEntity<?> createClient(@RequestBody Client client) {
	     if (clientService.isEmailAlreadyRegistered(client.getEmail())) {
	         String errorMessage = "Usuário já cadastrado em nosso banco!";
	         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
	     }

	     Client createdClient = clientService.insert(client);
	     return ResponseEntity.status(HttpStatus.CREATED).body(createdClient);
	 }

	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
	     clientService.deleteById(id);
	     return ResponseEntity.noContent().build();
	 }
	 
     @PostMapping(value = "/login")
	 public ResponseEntity<String> login(@RequestBody ClientLoginRequest request) {
	        boolean isAuthenticated = clientService.login(request.getEmail(), request.getPassword());
	        if (isAuthenticated) {
	            String token = generateToken(request.getEmail()); 
	            String response = "token: " + token;
	            return ResponseEntity.ok(response);
	        } else {
	        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falha na autenticação do usuário.");
	        }
	    }
     
     @SuppressWarnings("unused")
	private String generateToken(String email) {

         String secretKey = "seuSegredo";
         long expirationTime = 86400000; 
         
         String token = Jwts.builder()
                 .setSubject(email)
                 .setIssuedAt(new Date())
                 .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                 .signWith(SignatureAlgorithm.HS512, secretKey)
                 .compact();

         return token;
     }
	 
}
