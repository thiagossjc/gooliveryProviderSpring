package com.engrenelog.engrenemc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.engrenelog.engrenemc.services.DbService;
import com.engrenelog.engrenemc.services.EmailService;
import com.engrenelog.engrenemc.services.SmtpEmailService;

@Configuration
@Profile("test")
public class DevConfig {

	@Autowired
	private DbService dbService;
	
	@Value("${spring.jpa.hibernate.dll-auto}")
	private String dllAuto;

	
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		if (!"create".equals(dllAuto)) {
			return false;
		}
		dbService.instantiateTestDataBase();
		return true;
	}
	
	@Bean
	public EmailService emailService() {
		return new SmtpEmailService();
	}
}
