package com.engrenelog.engrenemc.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.engrenelog.engrenemc.domains.OrderCustomer;
import com.engrenelog.engrenemc.services.OrderCustomerService;
import com.engrenelog.engrenemc.services.TicketService;

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
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody OrderCustomer obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}	