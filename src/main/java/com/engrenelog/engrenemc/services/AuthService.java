package com.engrenelog.engrenemc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.engrenelog.engrenemc.domains.Customer;
import com.engrenelog.engrenemc.repositorys.CustomerRepository;
import com.engrenelog.engrenemc.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private EmailService emailService;
	
	private Random random = new Random();
	
	public void sendNewPassword(String email) {
		Customer customer = repo.findByEmail(email);
		if (customer == null){
		
			throw new ObjectNotFoundException("Email não encontrado");
			
		}
		
		String newPassword = newPassword();
		customer.setPassword(bcrypt.encode(newPassword));
		
		repo.save(customer);
		emailService.sendNewPasswordEmail(customer, newPassword);
	}

	private String newPassword() {
		// TODO Auto-generated method stub
		char[] vet = new char[10];
		for (int i=0;i<10;i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
			int opt= random.nextInt(3);
			if (opt==0) {//gera um dígito
				return (char) (random.nextInt(10) + 48);
			}
			else if (opt ==1) {//genera letras maiusculas
				return (char) (random.nextInt(26)+ 65);	
			}{//letra minuscula
				return (char) (random.nextInt(26)+ 97);
			}
	}
	
	
	

}
