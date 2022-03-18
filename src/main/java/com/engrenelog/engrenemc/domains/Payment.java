package com.engrenelog.engrenemc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.engrenelog.engrenemc.domains.enums.StatePayment;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Payment implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	private Integer statePay;
	
	@OneToOne
	@JoinColumn(name="order_id")
	@MapsId
	private Order order;	
	
	
	public Payment() {
		
	}

	public Payment(Integer id, StatePayment statePay, Order order) {
		super();
		this.id = id;
		this.statePay = statePay.getID();
		this.order = order;
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
	
	
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
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
