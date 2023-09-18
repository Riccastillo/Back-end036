package com.app.carro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.carro.entity.Carro;

@SpringBootApplication
public class SpringbootServiceCarroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceCarroApplication.class, args);
		
		Carro car = new Carro();
		car.setId((long) 111);
		
	}

}
