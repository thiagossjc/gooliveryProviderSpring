package com.engrenelog.engrenemc.domains;

import java.util.Date;

public class PaymentWithTicket extends Payment {
	private Date dateExpire;
	private Date datePayment;
	
	
	public PaymentWithTicket() {
		
	}


	public PaymentWithTicket(Date dateExpire, Date datePayment) {
		super();
		this.dateExpire = dateExpire;
		this.datePayment = datePayment;
	}
	
	
}