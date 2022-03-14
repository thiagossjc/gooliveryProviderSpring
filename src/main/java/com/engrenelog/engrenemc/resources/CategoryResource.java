package com.engrenelog.engrenemc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.engrenemc.domain.Category;

@RestController
@RequestMapping(value="/categorys")

public class CategoryResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Category> listing() {
		Category cat1 = new Category(1,"Informática");
		Category cat2 = new Category(2,"Escritório");
				
		//Criar un Array List
		List<Category> lists = new ArrayList<>();		//interface
		lists.add(cat1);
		lists.add(cat2);
		
		return lists;
	}
}
