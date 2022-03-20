package com.engrenelog.engrenemc.services;
import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.engrenelog.engrenemc.domains.Category;
import com.engrenelog.engrenemc.dto.CategoryDTO;
import com.engrenelog.engrenemc.repositorys.CategoryRepository;
import com.engrenelog.engrenemc.services.exceptions.DataIntegrityException;

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
	
	public Category update(Category obj) {
		
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try { 
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("No es posible deletar unca categoria que possuí produtos");
		}
	}
	
	public List<Category> findAll(){
		return repo.findAll();
	}
	
	public Page<Category>FindPage(Integer page, Integer linesPerPage,String orderBy, String direction){
			PageRequest pageRequest = PageRequest.of(page, 	linesPerPage, Direction.valueOf(direction),orderBy);
			
			return repo.findAll(pageRequest);
	}
	
	public Category fromDTO(CategoryDTO objDto) {
		return new Category(objDto.getId(),objDto.getName());
	}
}