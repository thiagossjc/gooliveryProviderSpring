package com.engrenelog.engrenemc.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engrenelog.engrenemc.domains.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {	
}
