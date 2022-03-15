package com.engrenelog.engrenemc.domains;

import java.util.Date;

public class PaymentWithCard extends Payment {
	private Integer numberInstallments;
	
	public PaymentWithCard() {
	}

	public PaymentWithCard(Integer numberInstallments) {
		super();
		this.numberInstallments = numberInstallments;
	}

	public Integer getNumberInstallments() {
		return numberInstallments;
	}

	public void setNumberInstallments(Integer numberInstallments) {
		this.numberInstallments = numberInstallments;
	}
}
