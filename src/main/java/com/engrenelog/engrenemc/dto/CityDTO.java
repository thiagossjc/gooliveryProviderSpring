package com.engrenelog.engrenemc.dto;

import java.io.Serializable;

import com.engrenelog.engrenemc.domains.City;
import com.engrenelog.engrenemc.domains.State;

public class CityDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private State state;
	
	public CityDTO() {	
	}
	
	public CityDTO(City city) {
		this.setId(city.getId());
		this.setName(city.getName());
		this.setState(city.getState());
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
}
