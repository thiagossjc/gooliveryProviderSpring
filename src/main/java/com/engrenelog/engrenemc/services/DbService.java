package com.engrenelog.engrenemc.services;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.engrenelog.engrenemc.domains.Address;
import com.engrenelog.engrenemc.domains.Category;
import com.engrenelog.engrenemc.domains.City;
import com.engrenelog.engrenemc.domains.Customer;
import com.engrenelog.engrenemc.domains.Product;
import com.engrenelog.engrenemc.domains.State;
import com.engrenelog.engrenemc.domains.enums.TypeCustomer;
import com.engrenelog.engrenemc.repositorys.AddressRepository;
import com.engrenelog.engrenemc.repositorys.CategoryRepository;
import com.engrenelog.engrenemc.repositorys.CityRepository;
import com.engrenelog.engrenemc.repositorys.CustomerRepository;
import com.engrenelog.engrenemc.repositorys.OrderCustomerRepository;
import com.engrenelog.engrenemc.repositorys.OrderItemRepository;
import com.engrenelog.engrenemc.repositorys.PaymentRepository;
import com.engrenelog.engrenemc.repositorys.ProductRepository;
import com.engrenelog.engrenemc.repositorys.StateRepository;

@Service
public class DbService {
	@Autowired
	private CategoryRepository categRepo;
	@Autowired	
	private ProductRepository  prodRepo;
	@Autowired
	private StateRepository stateRepo;
	@Autowired
	private CityRepository cityRepo;
	@Autowired
	private AddressRepository addressRepo;
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
	private OrderCustomerRepository orderRepo;
	@Autowired
	private PaymentRepository paymRepo;
	@Autowired
	private OrderItemRepository ordItemRepo;
	@Autowired
	private BCryptPasswordEncoder bCrypt;

	
	
	public void instantiateTestDataBase() throws ParseException {
		
		Category cat1 = new Category(null,"Informática");
		Category cat2 = new Category(null,"Escritório");
		
		Product prod1 = new Product(null,"Computadora",2000.00);
		Product prod2 = new Product(null,"Impressora",2000.00);
		Product prod3 = new Product(null,"Monitor",2000.00);
		
		State state1 = new State(null,"MG");
		State state2 = new State(null,"RJ");
		State state3 = new State(null,"SP");
		
		City  cit1    = new City(null,"Uberlandia",state1);
		City  cit2    = new City(null,"Três Corações",state1);
		City  cit3    = new City(null,"Rio de Janeiro",state2);
		City cit4 = new City(null,"Duque de Caxias",state2);
		City cit5 = new City(null,"São Paulo",state3);
		City cit6 = new City(null,"Barueri",state3);
		
		
		Customer cli1 = new Customer(null,"Maria Silva","maria@gmail.com","2343242342",TypeCustomer.PhisicalPerson,bCrypt.encode("teste"));
		cli1.getPhones().addAll(Arrays.asList("34324324","9823424"));
		
		Customer cli2 = new Customer(null,"José Silva","jose@gmail.com","2343242342",TypeCustomer.PhisicalPerson,bCrypt.encode("teste"));
		cli1.getPhones().addAll(Arrays.asList("34324324","9823424"));
		
		Address e1 = new Address(null,"Rua Maria Lobato","1","Copacabana", "25001",cli1,cit1);
		Address e2 = new Address(null,"Rua Maria Lobato","1","Copacabana", "25001",cli1,cit3);	
		
		/*
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		OrderCustomer ord1 = new OrderCustomer(null,sdf.parse("30/12/2012 10:32"),cli1, e1);
		OrderCustomer ord2 = new OrderCustomer(null,sdf.parse("20/12/2012 11:32"),cli1,e2);
		
		Payment pay1 = new PaymentWithCard(null,StatePayment.Settled,ord1,6);
		ord1.setPayment(pay1);
		Payment pay2 = new PaymentWithTicket(null,StatePayment.Pendente,ord2,sdf.parse("20/10/2014 01:17"),null);
		ord2.setPayment(pay2);
		
		cli1.getOrders().addAll(Arrays.asList(ord1,ord2));
		
		
		state1.getCities().addAll(Arrays.asList(cit1,cit2));
		state2.getCities().addAll(Arrays.asList(cit3,cit4));
		state3.getCities().addAll(Arrays.asList(cit5,cit6));
		
		cat1.getProducts().addAll(Arrays.asList(prod1,prod2,prod3));
		cat2.getProducts().addAll(Arrays.asList(prod2));
		
		prod1.getCategorys().addAll(Arrays.asList(cat1));
		prod2.getCategorys().addAll(Arrays.asList(cat1,cat2));
		prod3.getCategorys().addAll(Arrays.asList(cat2));

		cli1.getAddress().addAll(Arrays.asList(e1,e2));
		
		categRepo.saveAll(Arrays.asList(cat1,cat2));
		prodRepo.saveAll(Arrays.asList(prod1,prod2,prod3));
		stateRepo.saveAll(Arrays.asList(state1,state2,state3));
		cityRepo.saveAll(Arrays.asList(cit1,cit2,cit3,cit4,cit5,cit6));
		orderRepo.saveAll(Arrays.asList(ord1,ord2));		
		customerRepo.saveAll(Arrays.asList(cli1));
		addressRepo.saveAll(Arrays.asList(e1,e2));
		
		OrderItem	ip1 = new OrderItem(ord1,prod1,0.00,1,2000.00);
		OrderItem   ip2 = new OrderItem(ord1,prod3,0.00,2,80.00);
		OrderItem   ip3= new OrderItem(ord1,prod2,100.00,1,800.00);
		
		ord1.getItens().addAll(Arrays.asList(ip1,ip2));
		ord2.getItens().addAll(Arrays.asList(ip3));
		
		prod1.getItens().addAll(Arrays.asList(ip1));
		prod2.getItens().addAll(Arrays.asList(ip3));
		prod3.getItens().addAll(Arrays.asList(ip2));
		ordItemRepo.saveAll(Arrays.asList(ip1,ip2,ip3));

*/
		
	}
}
