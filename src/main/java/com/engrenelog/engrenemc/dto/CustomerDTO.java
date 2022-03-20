package com.engrenelog.engrenemc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.engrenelog.engrenemc.domains.Customer;

public class CustomerDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message= "El Preenchimento del nombre es obligatório!")
	@Length(min=5, max=129, message="El tamaño tiene que ser de el minimo 5 y el maximo 180!")
	private String name;
	@NotEmpty
	
	@NotEmpty(message= "El Preenchimento del email es obligatório!")
	@Email(message= "Email invalido!")
	private String email;
	
	
	public CustomerDTO(){		
	}

	public CustomerDTO(Customer obj) {
		this.id = obj.getId();		
		this.name = obj.getName();
		this.email = obj.getEmail();
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
