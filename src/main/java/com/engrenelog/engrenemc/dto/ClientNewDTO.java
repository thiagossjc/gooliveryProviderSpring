package com.engrenelog.engrenemc.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.engrenelog.engrenemc.services.validation.CustomerInsert;

//Anotación customizada para validar cpf y cnpj BR.
@CustomerInsert
public class ClientNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=5, max=120,message="La talla mayor que 5 y menor que 120 ")
	private String name;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Email
	private String email;
	
	
	private Integer typeC;
	@NotEmpty
	private String idCustmOrIdCompany;
	
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String street;
	@NotEmpty(message="Preenchimento obrigatório!")
	private String complement;
	@NotEmpty(message="Preenchimento obrigatório!")	
	private String neighborhood;
	@NotEmpty(message="Preenchimento obrigatório!")
	private String postalCode;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String phone1;
	
	private String phone2;
	private String phone3;
	private Integer cityId;
	
	public ClientNewDTO() {
		
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

	public String getIdCustmOrIdCompany() {
		return idCustmOrIdCompany;
	}

	public void setIdCustmOrIdCompany(String idCustmOrIdCompany) {
		this.idCustmOrIdCompany = idCustmOrIdCompany;
	}

	public Integer getTypeC() {
		return typeC;
	}

	public void setTypeC(Integer typeC) {
		this.typeC = typeC;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getNeighborhood() {
		return neighborhood;
	}

	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	
}
