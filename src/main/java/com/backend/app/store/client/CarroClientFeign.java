package com.backend.app.store.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.backend.app.store.models.Carro;

@FeignClient(name = "service-store")
public interface CarroClientFeign {
	
	@GetMapping("/list")
	public List<Carro> list();
	
	@GetMapping("/carro/{id}")
	public Carro detail(@PathVariable Long id);

}
