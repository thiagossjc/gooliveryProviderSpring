package com.engrenelog.engrenemc.services;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engrenelog.engrenemc.repositorys.CategoryRepository;
import com.engrenelog.engrenemc.domains.*;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repo;
	
	public Category find(Integer id) {
		 Optional<Category> obj = repo.findById(id); 
		 return obj.orElseThrow(() -> new ObjectNotFoundException( 
		  "Objeto não encontrado! Id: " + id + ", Categoria: " + Category.class.getName(), null)); 
	}
	
	public Category insert(Category obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}