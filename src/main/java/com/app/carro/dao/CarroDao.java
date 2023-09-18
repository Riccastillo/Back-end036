package com.app.carro.dao;

import org.springframework.data.repository.CrudRepository;

import com.app.carro.entity.Carro;

public interface CarroDao extends CrudRepository<Carro, Long>{

}
