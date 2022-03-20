package com.engrenelog.engrenemc.dto;

import java.io.Serializable;

public class ClientNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String idCustmOrIdCompany;
	private Integer typeC;
	
	private String street;
	private String complement;
	private String neighborhood;
	private String postalCode;
	
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
