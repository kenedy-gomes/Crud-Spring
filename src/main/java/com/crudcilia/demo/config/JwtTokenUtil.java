 package com.crudcilia.demo.config;

 

 
import java.sql.Date;

import org.springframework.stereotype.Service;

 
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenUtil {

	@SuppressWarnings("unused")
	private String generateToken(String username) {
   
        String secretKey = "seuSegredo";
        long expirationTime = 86400000; // 24 horas

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(expirationTime))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();

        return token;
    }
}
 
