package com.engrenelog.engrenemc.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.engrenelog.engrenemc.domains.enums.TypeCustomer;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String email;
	private String idCustmOrIdCompany;
	private Integer typeC;
	
	@JsonManagedReference
	@OneToMany(mappedBy="customer")
	private List<Address> address = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="phones")
	private Set<String> phones = new HashSet<>();

	public Customer() {
		
	}

	public Customer(Integer id, String name, String email, String idCustmOrIdCompany, TypeCustomer typeC) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.idCustmOrIdCompany = idCustmOrIdCompany;
		this.typeC = typeC.getID();
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

	public String getIdCustmOrIdCompany() {
		return idCustmOrIdCompany;
	}

	public void setIdCustmOrIdCompany(String idCustmOrIdCompany) {
		this.idCustmOrIdCompany = idCustmOrIdCompany;
	}

	public TypeCustomer getTypeC() {
		
		return TypeCustomer.ToEnum(typeC) ;
	}

	public void setTypeC(TypeCustomer typeC) {
		this.typeC = typeC.getID();
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(id, other.id);
	}
}
