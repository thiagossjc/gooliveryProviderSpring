package com.engrenelog.engrenemc.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engrenelog.engrenemc.domains.OrderCustomer;

@Repository
public interface OrderCustomerRepository extends JpaRepository<OrderCustomer,Integer> {	
}
