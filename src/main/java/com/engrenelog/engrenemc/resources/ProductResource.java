package com.engrenelog.engrenemc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.engrenelog.engrenemc.domains.Product;
import com.engrenelog.engrenemc.dto.ProductDTO;
import com.engrenelog.engrenemc.resources.utils.URL;
import com.engrenelog.engrenemc.services.ProductService;

@RestController
@RequestMapping(value="/products")

public class ProductResource {

	@Autowired
	private ProductService service;	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Product> find(@PathVariable Integer id) {
	

		Product obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
	}
	
	
	@RequestMapping(value= "/page",method=RequestMethod.GET)
	public ResponseEntity<Page<ProductDTO>> findPage(
				@RequestParam(value="name",defaultValue="") String name,
				@RequestParam(value="category",defaultValue="") String categories,
				@RequestParam(value="page",defaultValue="0") Integer page,
				@RequestParam(value="linesPerPage",defaultValue="24") Integer linesPerPage,
				@RequestParam(value="page",defaultValue="0") String orderBy,
				@RequestParam(value="page",defaultValue="ASC") String direction)
		{
		String nameDecode = URL.decodeParam(name);
		List<Integer> ids = URL.decodeIntList(categories);
		Page<Product> list = service.search(nameDecode,ids,page,linesPerPage,orderBy,direction);
		Page<ProductDTO> listDto = list.map(obj -> new ProductDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}


}	