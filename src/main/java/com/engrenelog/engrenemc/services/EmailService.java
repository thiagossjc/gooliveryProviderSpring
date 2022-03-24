package com.engrenelog.engrenemc.services;

import org.springframework.mail.SimpleMailMessage;

import com.engrenelog.engrenemc.domains.OrderCustomer;

public interface EmailService {
	void sendOrderConfirmationEmail(OrderCustomer obj);
	void sendEmail(SimpleMailMessage msg);
}
