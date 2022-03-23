package com.engrenelog.engrenemc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.engrenelog.engrenemc.domains.Product;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=5, max=80,message="O tamanho deve ser entre 5 e 20 caracteres.")
	private String name;
	private Double price;
	
	
	public ProductDTO(){
	}


	public ProductDTO(Integer id,
			@NotEmpty(message = "Preenchimento obrigatório!") @Length(min = 5, max = 80, message = "O tamanho deve ser entre 5 e 20 caracteres.") String name,
			Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public ProductDTO(Product obj) {
		id= obj.getId();
		name= obj.getName();
		price= obj.getPrice();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}
}
	
	
	
	