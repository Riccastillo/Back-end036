package com.app.carro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.app.carro.entity.Carro;

@SpringBootApplication
@EnableEurekaClient
public class SpringbootServiceCarroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServiceCarroApplication.class, args);
		
		Carro car = new Carro();
		car.setId((long) 111);
		
	}

}
