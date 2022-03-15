package com.engrenelog.engrenemc;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.engrenelog.engrenemc.domains.Category;
import com.engrenelog.engrenemc.domains.Product;
import com.engrenelog.engrenemc.repositorys.CategoryRepository;
import com.engrenelog.engrenemc.repositorys.ProductRepository;

@SpringBootApplication
public class EngreneMcApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository categRepo;
	@Autowired	
	private ProductRepository  prodRepo;
	

	public static void main(String[] args) {
		SpringApplication.run(EngreneMcApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception{

		Category cat1 = new Category(null,"Informática");
		Category cat2 = new Category(null,"Escritório");
		Category cat3 = new Category(null,"Ropa");
		
		Product prod1 = new Product(null,"Computadora",2000.00);
		Product prod2 = new Product(null,"Impressora",2000.00);
		Product prod3 = new Product(null,"Monitor",2000.00);
		
		cat1.getProducts().addAll(Arrays.asList(prod1,prod2,prod3));
		cat2.getProducts().addAll(Arrays.asList(prod2));
		
		prod1.getCategorys().addAll(Arrays.asList(cat1));
		prod2.getCategorys().addAll(Arrays.asList(cat1,cat2));
		prod3.getCategorys().addAll(Arrays.asList(cat2));
		
		categRepo.saveAll(Arrays.asList(cat1,cat2));
		prodRepo.saveAll(Arrays.asList(prod1,prod2,prod3));
	}
}
