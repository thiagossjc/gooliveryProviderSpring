package com.engrenelog.engrenemc.repositorys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.engrenelog.engrenemc.domains.Customer;
import com.engrenelog.engrenemc.domains.OrderCustomer;

@Repository
public interface OrderCustomerRepository extends JpaRepository<OrderCustomer,Integer> {	
	@Transactional(readOnly=true)
	Page<OrderCustomer> findByCustomer(Customer customer, Pageable pageRequest);
}
