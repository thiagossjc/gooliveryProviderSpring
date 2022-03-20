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
import org.springframework.transaction.annotation.Transactional;

import com.engrenelog.engrenemc.domains.Address;
import com.engrenelog.engrenemc.domains.City;
import com.engrenelog.engrenemc.domains.Customer;
import com.engrenelog.engrenemc.domains.enums.TypeCustomer;
import com.engrenelog.engrenemc.dto.ClientNewDTO;
import com.engrenelog.engrenemc.dto.CustomerDTO;
import com.engrenelog.engrenemc.repositorys.AddressRepository;
import com.engrenelog.engrenemc.repositorys.CityRepository;
import com.engrenelog.engrenemc.repositorys.CustomerRepository;
import com.engrenelog.engrenemc.services.exceptions.DataIntegrityException;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repo;
	
	@Autowired
	private CityRepository repoCity;
	
	@Autowired
	private AddressRepository repoAddress;
	
	public Customer find(Integer id) {
		 Optional<Customer> obj = repo.findById(id); 
		 return obj.orElseThrow(() -> new ObjectNotFoundException( 
		  "Objeto não encontrado! Id: " + id + ", Customer: " + Customer.class.getName(), null)); 
	} 
	
	@Transactional
	public Customer insert(Customer obj) {
		obj.setId(null);
		
		obj = repo.save(obj);
		repoAddress.saveAll(obj.getAddress()); 

		return obj;
	}
	
	public Customer update(Customer obj) {
		Customer newObj = find(obj.getId());
		updateData(newObj,obj);
		return repo.save(newObj);
	}
	
	public void delete(Integer id) {
		find(id);
		try { 
			repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("No es posible deletar un Cliente que tenga Pedido");
		}
	}
	
	public List<Customer> findAll(){
		return repo.findAll();
	}
	
	public Page<Customer>FindPage(Integer page, Integer linesPerPage,String orderBy, String direction){
			PageRequest pageRequest = PageRequest.of(page, 	linesPerPage, Direction.valueOf(direction),orderBy);
			
			return repo.findAll(pageRequest);
	}
	
	public Customer fromDTO(CustomerDTO objDto) {
		return new Customer(objDto.getId(),objDto.getName(),objDto.getEmail(),null,null);
	}

	public Customer fromDTO(ClientNewDTO objDto) {
		Customer cli = new Customer(null,
				                    objDto.getName(),
				                    objDto.getEmail(),
				                    objDto.getIdCustmOrIdCompany(),
				                    TypeCustomer.ToEnum(objDto.getTypeC())
				                    );
		City city = repoCity.getById(objDto.getCityId());		

		Address adres = new Address(null,
				                    objDto.getStreet(),
				                    objDto.getComplement(),
				                    objDto.getNeighborhood(),
				                    objDto.getPostalCode(),
				                    cli,
				                    city
				                    );
		

		cli.getAddress().add(adres);
		cli.getPhones().add(objDto.getPhone1());
		if (objDto.getPhone2() != null) {
			cli.getPhones().add(objDto.getPhone2());
		}
		if (objDto.getPhone3() != null) {
			cli.getPhones().add(objDto.getPhone3());
		}
		return cli;		
	}

	
	private  void updateData(Customer newObj, Customer obj) {
			newObj.setName(obj.getName());
			newObj.setEmail(obj.getEmail());
	}
}