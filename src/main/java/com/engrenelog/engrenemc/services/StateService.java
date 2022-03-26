package com.engrenelog.engrenemc.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.engrenelog.engrenemc.domains.State;
import com.engrenelog.engrenemc.repositorys.StateRepository;

@Service
public class StateService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@Autowired
	private StateRepository repo;
		
	public List<State>findAll(){
	 
			return repo.findAllByOrderByName();
	}
}
