package com.engrenelog.engrenemc.repositorys;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.engrenelog.engrenemc.domains.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	@Transactional(readOnly=true)
	Customer findByEmail(String email);
}
