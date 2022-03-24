package com.engrenelog.engrenemc.services;

import java.util.Date;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.engrenelog.engrenemc.domains.OrderCustomer;
import com.engrenelog.engrenemc.domains.OrderItem;
import com.engrenelog.engrenemc.domains.PaymentWithTicket;
import com.engrenelog.engrenemc.domains.enums.StatePayment;
import com.engrenelog.engrenemc.repositorys.OrderCustomerRepository;
import com.engrenelog.engrenemc.repositorys.OrderItemRepository;
import com.engrenelog.engrenemc.repositorys.PaymentRepository;

@Service
public class OrderCustomerService {

	@Autowired
	private OrderCustomerRepository repo;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private PaymentRepository payRepo;
	@Autowired
	private ProductService prodServ;
	@Autowired
	private OrderItemRepository oiRepo;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EmailService emailService;
	
	public OrderCustomer find(Integer id) {
		Optional<OrderCustomer> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Order: " + OrderCustomer.class.getName(), null));
	}

	@Transactional
	public OrderCustomer insert(OrderCustomer obj) {
		obj.setId(null);
		obj.getPayment().setStatePay(StatePayment.Pendente);
		obj.setInstante(new Date());
		obj.setCustomer(customerService.find(obj.getCustomer().getId()));
		obj.getPayment().setOrderCustomer(obj);

		if (obj.getPayment() instanceof PaymentWithTicket) {
			PaymentWithTicket paymt = (PaymentWithTicket) obj.getPayment();
			ticketService.FillInPaymentWithTicket(paymt,obj.getInstante());
		}

		obj = repo.save(obj);
		payRepo.save(obj.getPayment());
		
		for (OrderItem oi : obj.getItens()) {
			oi.setDiscount(0.0);
			oi.setProduct(prodServ.find(oi.getProduct().getId()));
			oi.setPrice(oi.getProduct().getPrice());
			oi.setOrderCustomer(obj);
			
		}
		oiRepo.saveAll(obj.getItens());
		emailService.sendOrderConfirmationEmail(obj);
		//System.out.println(obj);
		
		return obj;
	}
}