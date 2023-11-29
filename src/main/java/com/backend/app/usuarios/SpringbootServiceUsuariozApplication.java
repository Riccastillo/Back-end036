package com.backend.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan({"com.backend.app.commons.users.entity"})
@SpringBootApplication
public class SpringbootServiceUsuariozApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceUsuariozApplication.class, args);
	}

}
