package com.engrenelog.engrenemc.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engrenelog.engrenemc.domains.City;

@Repository
public interface CityRepository extends JpaRepository<City,Integer>  {
	
}
