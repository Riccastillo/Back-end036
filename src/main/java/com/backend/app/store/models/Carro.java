package com.backend.app.store.models;

public class Carro {
	
	private Long id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	private String name;
	
	private String marca;
	
	private String color;
	
	public Carro(Long id, String name, String marca) {
		this.id=id;
		this.name=name;
		this.marca=marca;
	}
	

}
