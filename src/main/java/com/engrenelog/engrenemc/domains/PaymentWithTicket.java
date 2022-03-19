package com.engrenelog.engrenemc.domains;

import java.util.Date;

import javax.persistence.Entity;

import com.engrenelog.engrenemc.domains.enums.StatePayment;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PaymentWithTicket extends Payment {

	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dateExpire;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date datePayment;
	
	
	public PaymentWithTicket() {
		
	}


	public PaymentWithTicket(Integer id, StatePayment statePay, OrderCustomer orderCustomer, Date dateExpire, Date datePayment) {
		super(id, statePay,orderCustomer);
		

		this.dateExpire = dateExpire;
		
		this.datePayment = datePayment;
	}


	public Date getDateExpire() {
		return dateExpire;
	}


	public void setDateExpire(Date dateExpire) {
		this.dateExpire = dateExpire;
	}


	public Date getDatePayment() {
		return datePayment;
	}


	public void setDatePayment(Date datePayment) {
		this.datePayment = datePayment;
	}
	
}