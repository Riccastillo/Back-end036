package com.app.carro.service;

import java.util.List;

import com.app.carro.entity.Carro;

public interface CarroService {

	/* *
	 * este metodo retorna un listado de todos los carros
	 * */ 
	public List<Carro> findAll();
	
	public Carro findById(Long id);
	
	/////////////////////////
	public void deleteById(Long id);

	public Carro save(Carro instance);
	
	public boolean existsById(Long id);
	
	
	
	
	//@DeleteMapping
		//@PostMapping
		//@Put
}
