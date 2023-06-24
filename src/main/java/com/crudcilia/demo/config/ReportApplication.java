package com.crudcilia.demo.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.crudcilia.demo.CrudApplication;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ReportApplication {
	 public static void main(String[] args) throws Exception {
	        SpringApplication.run(CrudApplication.class, args);
	    }
}
