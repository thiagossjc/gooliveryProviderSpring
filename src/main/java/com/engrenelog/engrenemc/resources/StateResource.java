package com.engrenelog.engrenemc.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.engrenelog.engrenemc.domains.City;
import com.engrenelog.engrenemc.domains.State;
import com.engrenelog.engrenemc.dto.CityDTO;
import com.engrenelog.engrenemc.dto.StateDTO;
import com.engrenelog.engrenemc.services.CityService;
import com.engrenelog.engrenemc.services.StateService;

@RestController
@RequestMapping(value="/states")
public class StateResource {

	@Autowired
	private StateService service;
	
	@Autowired
	private CityService serviCity;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<StateDTO>> findAll(){
		List<State> list = service.findAll();
		List<StateDTO> listDto = list.stream().map(obj -> new StateDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/{estadoId}/cities",method=RequestMethod.GET)
	public ResponseEntity<List<CityDTO>> findCityesByState(){
		List<City> list = serviCity.findCity(null);
		List<CityDTO> listDto = list.stream().map(obj -> new CityDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	 
	
}
