package com.engrenelog.engrenemc.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engrenelog.engrenemc.domains.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {
	
}
