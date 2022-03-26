package com.engrenelog.engrenemc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engrenelog.engrenemc.domains.City;
import com.engrenelog.engrenemc.repositorys.CityRepository;

@Service
public class CityService {
	@Autowired
	private CityRepository repo;
	
	public List<City>findAll(){
		 
		return repo.findAllByOrderByName();
	}
	
	public List<City>findCity(Integer id_state){
		return repo.findCities(id_state);
	}
}
