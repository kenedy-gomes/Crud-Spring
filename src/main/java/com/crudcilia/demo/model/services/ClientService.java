package com.crudcilia.demo.model.services;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.crudcilia.demo.DTO.ClientDTO;
import com.crudcilia.demo.model.Client;
import com.crudcilia.demo.model.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	@CrossOrigin(origins = "http://localhost:4200")
	public List<Client> findall() {
		return clientRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	public Client findById(Long id) {
		Optional<Client> obj = clientRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado", obj));
	} 
	
	@CrossOrigin(origins = "http://localhost:4200")
	 public Client insert(Client client) {
        return clientRepository.save(client);
    }
	
	 
	@CrossOrigin(origins = "http://localhost:4200")
	  public void deleteById(Long id) {
	        clientRepository.deleteById(id);
	    }
	
	
    @CrossOrigin(origins = "http://localhost:4200")
    public boolean login(String email, String password) {
        Client user =  clientRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return  true;
        }
        return false;
    }

	public boolean isEmailAlreadyRegistered(String email) {
		List<Client> clients = clientRepository.findAll();

        for (Client client : clients) {
            if (client.getEmail().equals(email)) {
                return false; 
            }
        }

        return false;  
	}

 
	
}
