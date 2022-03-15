package com.engrenelog.engrenemc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.engrenelog.engrenemc.repositorys.CategoryRepository;

@SpringBootApplication
public class EngreneMcApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categRepos;
	
	public static void main(String[] args) {
		SpringApplication.run(EngreneMcApplication.class, args);
	}
	
	@Override
	public void run(Strint...args) throws Exception{
		Category cat1 = new Category(null,"Informática");
		Category cat2 = new Category(null,"Escritório");
		Category cat2 = new Category(null,"Ropa");
		
	}
}
