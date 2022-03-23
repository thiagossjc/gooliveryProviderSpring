package com.engrenelog.engrenemc.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.engrenelog.engrenemc.domains.PaymentWithTicket;

@Service
public class TicketService {
	public void FillInPaymentWithTicket(PaymentWithTicket paymt,Date orderDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(orderDate);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		paymt.setDateExpire(cal.getTime());
	}
}
