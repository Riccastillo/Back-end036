package com.backend.app.store.models;

public class Store {
	private Carro car;
	private Integer cantidad;
	
	public Carro getCar() {
		return car;
	}
	public void setCar(Carro car) {
		this.car = car;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	//constructores
	public Store() {
		
	}
	
	public Store(Carro car, Integer cantidad) {
		
		this.car = car;
		this.cantidad = cantidad;
	}
	
	

}
