package com.engrenelog.engrenemc.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engrenelog.engrenemc.domains.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
	
}
