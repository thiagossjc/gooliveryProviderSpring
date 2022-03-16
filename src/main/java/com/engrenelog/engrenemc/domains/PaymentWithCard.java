package com.engrenelog.engrenemc.domains;

import javax.persistence.Entity;

import com.engrenelog.engrenemc.domains.enums.StatePayment;

@Entity
public class PaymentWithCard extends Payment {

	private static final long serialVersionUID = 1L;
	
	private Integer numberInstallments;
	
	public PaymentWithCard() {
	}



	public PaymentWithCard(Integer id, StatePayment statePay, Order order,Integer numberInstallments) {
		super(id,statePay,order);
		this.numberInstallments = numberInstallments;
	}



	public Integer getNumberInstallments() {
		return numberInstallments;
	}

	public void setNumberInstallments(Integer numberInstallments) {
		this.numberInstallments = numberInstallments;
	}
}
