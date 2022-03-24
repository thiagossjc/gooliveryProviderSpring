package com.engrenelog.engrenemc.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.engrenelog.engrenemc.domains.OrderCustomer;

public abstract class AbstractEmailService implements EmailService {

	@Value("${default.sender}")
	private String sender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;

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
	
	protected String htmlFromTemplateOrder(OrderCustomer obj) {
		Context context = new Context();
		context.setVariable("order", obj);
		return templateEngine.process("email/confirmationOrder", context);
	}
	
	@Override
	public void sendOrderConfirmationHtmlEmail(OrderCustomer obj) {
		try {	
			MimeMessage mm  = preperMimeMessageFromOrder(obj); 	
			sendHtmlEmail(mm);
		}
		catch (MessagingException e) {
			sendOrderConfirmationEmail(obj);
		}
	}

	protected MimeMessage preperMimeMessageFromOrder(OrderCustomer obj) throws MessagingException {
			MimeMessage mimeMessage = javaMailSender.createMimeMessage();
			MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage,true);
			mmh.setTo(obj.getCustomer().getEmail());
			mmh.setFrom(sender);
			mmh.setSubject("Pedido confirmado! Cód. : " + obj.getId());
			mmh.setSentDate(new Date(System.currentTimeMillis()));
			mmh.setText(htmlFromTemplateOrder(obj),true);
			return mimeMessage;
			
			 
	}
}
