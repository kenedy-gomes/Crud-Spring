package com.crudcilia.demo.DTO;

public class LoginReponseDTO {

    private String token;
	
	public LoginReponseDTO() {}

	public LoginReponseDTO(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}
