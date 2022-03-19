package com.engrenelog.engrenemc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.engrenelog.engrenemc.domains.OrderCustomer;
import com.engrenelog.engrenemc.services.OrderCustomerService;

@RestController
@RequestMapping(value="/order")

public class OrderCustomerResource {

	@Autowired
	private OrderCustomerService service;	
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<OrderCustomer> find(@PathVariable Integer id) {
	
		OrderCustomer obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}	