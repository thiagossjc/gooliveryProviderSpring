package com.engrenelog.engrenemc.domains;

import javax.persistence.Entity;

import com.engrenelog.engrenemc.domains.enums.StatePayment;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("paymentwithcard")
public class PaymentWithCard extends Payment {

	private static final long serialVersionUID = 1L;
	
	private Integer numberInstallments;
	
	public PaymentWithCard() {
	}


	
	public PaymentWithCard(Integer id, StatePayment statePay, OrderCustomer orderCustomer,Integer numberInstallments) {
		super(id,statePay,orderCustomer);
		this.numberInstallments = numberInstallments;
	}



	public Integer getNumberInstallments() {
		return numberInstallments;
	}

	public void setNumberInstallments(Integer numberInstallments) {
		this.numberInstallments = numberInstallments;
	}
	
}
