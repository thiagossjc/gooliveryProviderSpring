package com.engrenelog.engrenemc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.engrenelog.engrenemc.services.DbService;
import com.engrenelog.engrenemc.services.EmailService;
import com.engrenelog.engrenemc.services.MockEmailService;

@Configuration
@Profile("dev")
public class TestConfig {

	@Autowired
	private DbService dbService;
	
	@Bean
	public boolean instantiateDataBase() throws ParseException {
		dbService.instantiateTestDataBase();
		return true;
	}
	
	@Bean
	public 	EmailService emailService() {
		return new MockEmailService();
		
	}
}
