package com.engrenelog.engrenemc.domains;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.engrenelog.engrenemc.domains.enums.StatePayment;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)  //mapeamento herança JOINED SEPARA LAS TABELAS
public class Payment implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	private Integer id;
	
	private StatePayment statePay;
	
	@OneToOne
	@JoinColumn(name="order_id")
	@MapsId
	private Order order;
	
	
	public Payment() {
		
	}

	public Payment(Integer id, StatePayment statePay, Order order) {
		super();
		this.id = id;
		this.statePay = statePay;
		this.order = order;
	}





	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public StatePayment getStatePay() {
		return statePay;
	}
	public void setStatePay(StatePayment statePay) {
		this.statePay = statePay;
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
