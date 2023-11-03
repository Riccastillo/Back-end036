package com.app.carro.controllers;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	private Environment env;
	
	@Autowired
	private CarroService service;
	
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/list")
	public List<Carro> list(){
		return service.findAll().stream().map(car -> {
			car.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			return car;
		}).collect(Collectors.toList());
	}
	
	@GetMapping("/carro/{id}")
	public Carro detail(@PathVariable Long id) {
		
		//boolean bl = false;
		//if(!bl)
			//throw new RuntimeException("No se pudo obtener el detalle del carro seleccionado");
		try {
			Thread.sleep(2000L);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return service.findById(id);
	}
	
	////////////////////
	@DeleteMapping("/carro/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping("/carro/create/")
	public ResponseEntity<Carro> create(@RequestBody Carro instance) {
		Carro saveCar = service.save(instance);
		return new ResponseEntity<>(saveCar, HttpStatus.CREATED);
	}
	
	@PutMapping("/carro/update/{id}")
	public ResponseEntity<Carro> update(@RequestBody Carro instance, @PathVariable Long id) {
		if(service.existsById(id)) {
			instance.setId(id);
			Carro updateCarro = service.save(instance);
			return new ResponseEntity<>(updateCarro, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	//@PostMapping
	//@Put
	
}
