package com.backend.app.store.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backend.app.store.models.Carro;
import com.backend.app.store.models.Store;
import com.backend.app.store.services.StoreService;

@Service("serviceRest")
public class StoreServiceImpl implements StoreService {

	@Autowired
	private RestTemplate clientRest;
	
	@Override
	public List<Store> findAll() {
		List<Carro> car = Arrays.asList(clientRest.getForObject("http://localhost:8080/list", Carro[].class));
		
		return car.stream().map(p-> new Store(p, 5)).collect(Collectors.toList());
	}

	@Override
	public Store findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables=new HashMap<>();
		pathVariables.put("id", id.toString());
		Carro car = clientRest.getForObject("http://localhost:8080/carro/{id}", Carro.class, pathVariables);
		return new Store(car, cantidad);
	}

}
