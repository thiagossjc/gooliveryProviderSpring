package com.engrenelog.engrenemc.domains;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
	
	private Integer id;
	private Date instante;
	
	private Payment payment;
	private Customer customer;
	private Address deliveryAddress;
	
	public Order(){
		
	}

	public Order(Integer id, Date instante, Payment payment, Customer customer) {
		super();
		this.id = id;
		this.instante = instante;
		this.payment = payment;
		this.customer = customer;
	}
	
	
	
	
	
	
}
