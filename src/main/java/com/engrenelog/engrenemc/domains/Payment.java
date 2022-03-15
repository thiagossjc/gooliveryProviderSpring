package com.engrenelog.engrenemc.domains;

import java.io.Serializable;
import java.util.Objects;

import com.engrenelog.engrenemc.domains.enums.StatePayment;

public class Payment implements Serializable {
	private Integer id;
	private StatePayment statePay;
	
	public Payment() {
		
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
