package com.app.carro.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.carro.dao.CarroDao;
import com.app.carro.entity.Carro;

@Service
public class CarroServiceImpl implements CarroService {
	
	@Autowired
	private CarroDao carroDao;

	@Override
	@Transactional(readOnly=true)
	public List<Carro> findAll() {

		return (List<Carro>) carroDao.findAll();
	}

	@Override
	public Carro findById(Long id) {

		return carroDao.findById(id).orElse(null);
	}
	
	//@DeleteMapping
		//@PostMapping
		//@Put

}
