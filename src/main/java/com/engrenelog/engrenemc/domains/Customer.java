package com.engrenelog.engrenemc.domains;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.engrenelog.engrenemc.domains.enums.TypeCustomer;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(unique=true)
	private String email;
	
	private String idCustmOrIdCompany;
	private Integer typeC;
	
	@JsonIgnore
	private String password;
	
	@OneToMany(mappedBy="customer",cascade=CascadeType.ALL)
	private List<Address> address = new ArrayList<>();
	
	@ElementCollection
	@CollectionTable(name="phones")
	private Set<String> phones = new HashSet<>();

	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<OrderCustomer> orders = new ArrayList<>();

	public Customer() {
	}

	public Customer(Integer id, String name, String email, String idCustmOrIdCompany, TypeCustomer typeC, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.idCustmOrIdCompany = idCustmOrIdCompany;
		this.typeC = (typeC == null) ? null : typeC.getID();
		this.password = password;
	}

	
	@JsonIgnore
	public List<OrderCustomer> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderCustomer> orders) {
		this.orders = orders;
	}

	public void setTypeC(Integer typeC) {
		this.typeC = typeC;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
