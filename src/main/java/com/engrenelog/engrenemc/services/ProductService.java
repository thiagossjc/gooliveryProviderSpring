package com.engrenelog.engrenemc.services;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.engrenelog.engrenemc.domains.Category;
import com.engrenelog.engrenemc.domains.Product;
import com.engrenelog.engrenemc.dto.ProductDTO;
import com.engrenelog.engrenemc.repositorys.CategoryRepository;
//import com.engrenelog.engrenemc.dto.ProductDTO;
import com.engrenelog.engrenemc.repositorys.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repoProduct;
	@Autowired
	private CategoryRepository repoCat;

	public Product find(Integer id) {
		Optional<Product> obj = repoProduct.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Categoria: " + Product.class.getName(), null));
	}

	public Page<Product> search(String name, List<Integer>ids, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Category> category = repoCat.findAllById(ids);
		return repoProduct.search(name, category,pageRequest);
				
	}
	
	

	public Product fromDTO(ProductDTO objDto) {
		return new Product(objDto.getId(), objDto.getName(),objDto.getPrice());
	}

	private void updateData(Product newObj, Product obj) {
		newObj.setName(obj.getName());
	}

}