package com.app.carro.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.app.carro.entity.Carro;
import com.app.carro.service.CarroService;

@RestController
public class CarroController {
	
	@Autowired
	private CarroService service;
	
	@GetMapping("/list")
	public List<Carro> list(){
		return service.findAll();
	}
	
	@GetMapping("/carro/{id}")
	public Carro detail(@PathVariable Long id) {
		return service.findById(id);
	}
	
	//@DeleteMapping
	//@PostMapping
	//@Put
	
}
