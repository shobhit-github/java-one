package com.learning.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Demo - Documentation", description = "This is sample project", version = "1.0", contact = @Contact(name = "Shobhit Sharma", email = "shobhitmusic1@gmail.com")))
public class JavaOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaOneApplication.class, args);
	}

}
