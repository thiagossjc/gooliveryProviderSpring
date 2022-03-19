package com.engrenelog.engrenemc.services;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engrenelog.engrenemc.repositorys.OrderCustomerRepository;
import com.engrenelog.engrenemc.domains.*;

@Service
public class OrderCustomerService {
	
	@Autowired
	private OrderCustomerRepository repo;
	
	public OrderCustomer find(Integer id) {
		 Optional<OrderCustomer> obj = repo.findById(id); 
		 return obj.orElseThrow(() -> new ObjectNotFoundException( 
		  "Objeto não encontrado! Id: " + id + ", Order: " + OrderCustomer.class.getName(), null)); 
	} 
}