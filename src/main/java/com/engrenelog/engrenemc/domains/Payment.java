package com.engrenelog.engrenemc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.engrenelog.engrenemc.domains.enums.StatePayment;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Payment implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	@Column(name="id_state_pay")
	private Integer statePay;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="order_customer_id")
	@MapsId
	private OrderCustomer orderCustomer;	
	
	
	public Payment() {
		
	}

	public Payment(Integer id, StatePayment statePay, OrderCustomer orderCustomer) {
		super();
		this.id = id;
		this.statePay = (statePay==null) ? null: statePay.getID());
		this.orderCustomer = orderCustomer;
	}





	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public StatePayment getStatePay() {
		return StatePayment.ToEnum(statePay);
	}
	public void setStatePay(StatePayment statePay) {
		this.statePay = statePay.getID();
	}
	
	
	
	public OrderCustomer getOrderCustomer() {
		return orderCustomer;
	}

	public void setOrderCustomer(OrderCustomer orderCustomer) {
		this.orderCustomer = orderCustomer;
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
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
}
