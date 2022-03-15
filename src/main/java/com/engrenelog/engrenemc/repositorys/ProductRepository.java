package com.engrenelog.engrenemc.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engrenelog.engrenemc.domains.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	
}
