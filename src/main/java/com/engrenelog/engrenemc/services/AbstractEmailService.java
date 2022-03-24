package com.engrenelog.engrenemc.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

import com.engrenelog.engrenemc.domains.OrderCustomer;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.sender}")
	private String sender;

	@Override
	public void sendOrderConfirmationEmail(OrderCustomer obj) {
		SimpleMailMessage sm = prepareSimpleEmailMessagefromOrder(obj);
		sendEmail(sm);

	}

	protected SimpleMailMessage prepareSimpleEmailMessagefromOrder(OrderCustomer obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getCustomer().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Pedido confirmado! Código: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	};
}
