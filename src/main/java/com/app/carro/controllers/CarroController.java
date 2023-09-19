package com.app.carro.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	////////////////////
	@DeleteMapping("/carro/delete/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteById(id);
		return "Se ha borrado el registro del carro seleccionado";
	}
	
	@PostMapping("/carro/create/")
	public Carro create(@RequestBody Carro carro) {
		return service.save(carro);
	}
	
	@PutMapping("/carro/update/{id}")
	public Carro update(@RequestBody Carro carro, @PathVariable Long id) {
		Carro nuevoCarro = service.findById(id);
				
		nuevoCarro.setName(carro.getName());
		nuevoCarro.setMarca(carro.getMarca());
		nuevoCarro.setColor(carro.getColor());
		
		return service.save(nuevoCarro);
	}
	
	//@PostMapping
	//@Put
	
}
