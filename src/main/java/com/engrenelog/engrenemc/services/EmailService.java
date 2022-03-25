package com.engrenelog.engrenemc.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.engrenelog.engrenemc.domains.Customer;
import com.engrenelog.engrenemc.domains.OrderCustomer;

public interface EmailService {
	void sendOrderConfirmationEmail(OrderCustomer obj);

	void sendEmail(SimpleMailMessage msg);

	void sendOrderConfirmationHtmlEmail(OrderCustomer obj);

	void sendHtmlEmail(MimeMessage msg);
	
	void sendNewPasswordEmail(Customer customer,String newPassword);
}
